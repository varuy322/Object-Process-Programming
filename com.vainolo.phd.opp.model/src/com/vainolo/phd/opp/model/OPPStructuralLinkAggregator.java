/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package com.vainolo.phd.opp.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Link Aggregator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.OPPStructuralLinkAggregator#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see com.vainolo.phd.opp.model.OPPPackage#getOPPStructuralLinkAggregator()
 * @model
 * @generated
 */
public interface OPPStructuralLinkAggregator extends OPPNode {
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind
   * @see #setKind(OPPStructuralLinkAggregatorKind)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPStructuralLinkAggregator_Kind()
   * @model
   * @generated
   */
  OPPStructuralLinkAggregatorKind getKind();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPStructuralLinkAggregator#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind
   * @see #getKind()
   * @generated
   */
  void setKind(OPPStructuralLinkAggregatorKind value);

} // OPPStructuralLinkAggregator
