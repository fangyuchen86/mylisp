package org.jack;

public class FormNode extends AbstractNode {

	@Override
	public void transform() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder("( Form");
		for(AbstractNode node : this.getChildren()){
			s.append(" " + node.toString());
		}
		s.append(" )");
		
		return s.toString();
	}

}
