package org.jack;

public class LiteralNode extends AbstractNode {
	
	private int type;
	public Object value;
	
	
	
	public LiteralNode(int type, Object value) {
		super();
		this.type = type;
		this.value = value;
	}

	@Override
	public void transform() {
		// TODO Auto-generated method stub

	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString(){
		return value.toString();
	}
	
	

}
