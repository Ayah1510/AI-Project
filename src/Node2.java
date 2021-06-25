

public class Node2 {

		 String city;
		 double cost;
		 String parent;
		 
		 public Node2() {
			 
		 }
	         
	     @Override
		public String toString() {
			return "Node2 [city=" + city + ", cost=" + cost + "]";
		}

	     
		public String getParent() {
			return parent;
		}

		public void setParent(String parent) {
			this.parent = parent;
		}

		public Node2(String city,double cost) {    
	         this.city = city;    
	         this.cost=cost;
	   
	     }

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		

		public double getCost() {
			return cost;
		}

		public void setCost(double cost) {
			this.cost = cost;
		}		
	     
	}


