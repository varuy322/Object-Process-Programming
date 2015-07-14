package com.vainolo.opm.editor.part;

import java.util.List;

import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.opm.editor.figure.OPMNodeFigure;
import com.vainolo.opm.editor.policy.OPConnectionEditPolicy;
import com.vainolo.opm.editor.policy.OPNodeDeleteEditPolicy;
import com.vainolo.opm.model.OPLinkView;
import com.vainolo.opm.model.OPModelBase;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPNodeView;


public abstract class OPMNodeEditPart extends AbstractGraphicalEditPart implements NodeEditPart, OPModelObserver {

	@Override
	protected void createEditPolicies() {
		installEditPolicy(UUID.randomUUID().toString(), new OPConnectionEditPolicy());
		installEditPolicy(UUID.randomUUID().toString(), new OPNodeDeleteEditPolicy());
	}

	@Override
	protected List<OPLinkView> getModelSourceConnections() {
		OPNodeView model = (OPNodeView) getModel();
		List<OPLinkView> ret = model.getLinks().stream().filter(l -> model.equals(l.getSource())).collect(Collectors.toList());
		return ret;
	}
	
	@Override
	protected List<OPLinkView> getModelTargetConnections() {
		OPNodeView model = (OPNodeView) getModel();
		List<OPLinkView> ret = model.getLinks().stream().filter(l -> model.equals(l.getTarget())).collect(Collectors.toList());
		return ret;
	}
	
	
	@Override
	public void activate() {
		if(!isActive())
			((OPModelBase) getModel()).addObserver(this);
		super.activate();
	}
	
	@Override
	public void deactivate() {
		if(isActive())
			((OPModelBase) getModel()).removeObserver(this);
		super.deactivate();
	}
	
	@Override
	public void acceptNotification(OPModelBase notifier) {
		refresh();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return ((OPMNodeFigure)getFigure()).getConnectionAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return ((OPMNodeFigure)getFigure()).getConnectionAnchor();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return ((OPMNodeFigure)getFigure()).getConnectionAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return ((OPMNodeFigure)getFigure()).getConnectionAnchor();
	}
	
}