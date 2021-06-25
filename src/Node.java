public class Node {
	 String city;
	 double arealDis;
	 double streetDis;
     String Parent;
     double heuristic;
     public Node(String city,double arealDis,double streetDis) {    
         this.city = city;    
         this.arealDis=arealDis;
         this.streetDis=streetDis;
     }

	@Override
	public String toString() {
		return "Node [city=" + city + ", arealDis=" + arealDis + ", streetDis=" + streetDis + ", Parent=" + Parent
				+ ", heuristic=" + heuristic + "]";
	}

	
	public double getHeuristic() {
		return heuristic;
	}

	public void setHeuristic(double heuristic) {
		this.heuristic = heuristic;
	}

	public String getParent() {
		return Parent;
	}

	public void setParent(String parent) {
		Parent = parent;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getArealDis() {
		return arealDis;
	}

	public void setArealDis(double arealDis) {
		this.arealDis = arealDis;
	}

	public double getStreetDis() {
		return streetDis;
	}

	public void setStreetDis(double streetDis) {
		this.streetDis = streetDis;
	}    
    
	
}