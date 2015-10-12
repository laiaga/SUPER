package view;

/**
 * Path to the different images
 * @author Alexandre Leonardi
 */
public enum ImagePath {
	BARRIER{
		public String toString() {
	    	return "res/img/barrier/barrier.png";
		}
	},
	BOAT{
		public String toString() {
			return "res/img/vehicles/boats/boat";
		}
	},
	CAR{
		public String toString() {
			return "res/img/vehicles/cars/car";
		}
	},
	BRIDGE{
		public String toString(){
			return "res/img/bridge/bridge2.png";
		}
	},
	BACKGROUND{
		public String toString() {
			return "res/img/background/background.png";
		}
	}
}
