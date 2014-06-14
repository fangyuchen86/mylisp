package org.jack;

import java.util.List;

public abstract class AbstractNode {
	private AbstractNode parent;
	
	private AbstractNode next;
	
	private List<AbstractNode> children;
	
	public abstract void transform();

	public AbstractNode getParent() {
		return parent;
	}

	public void setParent(AbstractNode parent) {
		this.parent = parent;
	}

	public List<AbstractNode> getChildren() {
		return children;
	}

	public void setChildren(List<AbstractNode> children) {
		this.children = children;
	}

	public AbstractNode getNext() {
		return next;
	}

	public void setNext(AbstractNode next) {
		this.next = next;
	}
	
	
	
}
