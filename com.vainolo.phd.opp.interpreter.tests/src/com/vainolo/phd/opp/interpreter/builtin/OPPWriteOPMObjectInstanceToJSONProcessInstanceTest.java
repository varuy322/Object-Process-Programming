/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.eclipsesource.json.JsonObject;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPWriteOPMObjectInstanceToJSON;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPPWriteOPMObjectInstanceToJSONProcessInstanceTest {

  private OPPObjectInstance writeJson(OPPObjectInstance opmObject) throws Exception {
    OPPWriteOPMObjectInstanceToJSON instance = new OPPWriteOPMObjectInstanceToJSON();
    instance.setArgument("object", opmObject);
    instance.call();
    return instance.getArgument("json");
  }

  @Test
  public void test_execute_intElement() throws Exception {
    OPPObjectInstance opmObject = OPPObjectInstance.createCompositeInstance();
    opmObject.addCompositePart("int", OPPObjectInstance.createFromValue(new BigDecimal(3)));
    OPPObjectInstance result = writeJson(opmObject);
    JsonObject jsonObject = JsonObject.readFrom(result.getStringValue());
    assertEquals(3, jsonObject.get("int").asInt());
  }

  @Test
  public void test_execute_doubleElement() throws Exception {
    OPPObjectInstance opmObject = OPPObjectInstance.createCompositeInstance();
    opmObject.addCompositePart("double", OPPObjectInstance.createFromValue(new BigDecimal(5.47)));
    OPPObjectInstance result = writeJson(opmObject);
    JsonObject jsonObject = JsonObject.readFrom(result.getStringValue());
    assertEquals(5.47, jsonObject.get("double").asDouble(), 0.00001);
  }

  @Test
  public void test_execute_stringElement() throws Exception {
    OPPObjectInstance opmObject = OPPObjectInstance.createCompositeInstance();
    opmObject.addCompositePart("name", OPPObjectInstance.createFromValue("hello"));
    OPPObjectInstance result = writeJson(opmObject);
    JsonObject jsonObject = JsonObject.readFrom(result.getStringValue());
    assertEquals("hello", jsonObject.get("name").asString());
  }

  @Test
  public void test_execute_stateElement() throws Exception {
    OPPObjectInstance opmObject = OPPObjectInstance.createCompositeInstance();
    opmObject.addCompositePart("bool", OPPObjectInstance.createFromValue("true"));
    OPPObjectInstance result = writeJson(opmObject);
    JsonObject jsonObject = JsonObject.readFrom(result.getStringValue());
    assertEquals("true", jsonObject.get("bool").asString());
  }

  @Test
  public void text_execute_multipleElements() throws Exception {
    OPPObjectInstance opmObject = OPPObjectInstance.createCompositeInstance();
    opmObject.addCompositePart("a", OPPObjectInstance.createFromValue(new BigDecimal(5)));
    OPPObjectInstance part = OPPObjectInstance.createCompositeInstance();
    part.addCompositePart("b1", OPPObjectInstance.createFromValue("hello"));
    part.addCompositePart("b2", OPPObjectInstance.createFromValue(new BigDecimal(5.43)));
    opmObject.addCompositePart("b", part);
    opmObject.addCompositePart("c", OPPObjectInstance.createFromValue("one"));
    OPPObjectInstance result = writeJson(opmObject);
    JsonObject json = JsonObject.readFrom(result.getStringValue());
    assertEquals(5, json.get("a").asInt());
    assertEquals("hello", json.get("b").asObject().get("b1").asString());
    assertEquals(5.43, json.get("b").asObject().get("b2").asDouble(), 0.0001);
    assertEquals("one", json.get("c").asString());
  }
}