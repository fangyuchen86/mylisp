package org.jack;

public class CallNode extends AbstractNode {

	@Override
	public void transform() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder("( Call");
		for(AbstractNode node : this.getChildren()){
			s.append(" " + node.toString());
		}
		s.append(" )");
		
		return s.toString();
	}

}
