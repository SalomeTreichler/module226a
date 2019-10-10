public class Cloud {
	
	private Circle[] cloud = new Circle[4];
	private int position = 150;
	
	public Cloud(){
	    cloud[0] = new Circle();
	    cloud[0].changeColor("blue");
	    cloud[0].moveHorizontal(position);
	    cloud[0].moveVertical(-80);
	    cloud[0].changeSize(40);
	    cloud[0].makeVisible();
	    
	    cloud[1] = new Circle();
	    cloud[1].changeColor("blue");
	    cloud[1].moveHorizontal(position - 25);
	    cloud[1].moveVertical(-90);
	    cloud[1].changeSize(50);
	    cloud[1].makeVisible();
	    
	    cloud[2] = new Circle();
	    cloud[2].changeColor("blue");
	    cloud[2].moveHorizontal(position - 40);
	    cloud[2].moveVertical(-80);
	    cloud[2].changeSize(40);
	    cloud[2].makeVisible();
	}
	
	public void moveCloud(int distance) {
		cloud[0].moveHorizontal(distance);
		cloud[1].moveHorizontal(distance);
		cloud[2].moveHorizontal(distance);
	}
}