import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemInCart {

	private StringProperty name = new SimpleStringProperty();
	private DoubleProperty quantity = new SimpleDoubleProperty();
	//StringProperty unitSize = new SimpleStringProperty();
	private  String size;
	private  String note;


	ItemInCart() {
		name.set("");
		quantity.set(0);
	//	unitSize.set("");
	}

	ItemInCart(String name, double quantity) {
		this.name.set(name);
		this.quantity.set(quantity);
		this.size = "";
		this.note = "";


	}
	ItemInCart(String name, double quantity,String size) {
		this.name.set(name);
		this.quantity.set(quantity);
		this.size = size;
		this.note= "";


	}
	ItemInCart(String name, double quantity,String size,String note) {
		this.name.set(name);
		this.quantity.set(quantity);
		this.size = size;
		this.note = note;


	}

	public final String getSize() { return this.size; }
	public final String getNote() { return this.note; }


	public final String getName() { return name.get(); }
	public final double getQuantity() { return quantity.get(); }

	public final void setName(String name) { this.name.set(name); }
	public final void setQuantity(double unitQuantity) { this.quantity.set(unitQuantity); }

	public StringProperty nameProperty() { return name; }
	public DoubleProperty quantityProperty() { return quantity; }

}


