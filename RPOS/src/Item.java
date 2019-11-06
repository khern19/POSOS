import javafx.beans.property.*;

import java.util.ArrayList;

public class Item {

	private StringProperty name = new SimpleStringProperty();
	private StringProperty unit = new SimpleStringProperty();
	private DoubleProperty unitQuantity = new SimpleDoubleProperty();
	private DoubleProperty unitPrice = new SimpleDoubleProperty();
	String unitSize = "";
	String unitNote = "";


	@Override
	public String toString() {  //this is needed for ComboBox
		return name.get();
	}

	public Item() {
		name.set("");
		unit.set("");
		unitQuantity.set(0);
		unitPrice.set(0);
		//unitSize.set("");
	}

	public Item(String name, String unit,  double unitQuantity, double unitPrice) {
		this.name.set(name);
		this.unit.set(unit);
		this.unitQuantity.set(unitQuantity);
		this.unitPrice.set(unitPrice);

	}
	public Item(String name, String unit,  double unitQuantity, double unitPrice,String size) {
		this.name.set(name);
		this.unit.set(unit);
		this.unitQuantity.set(unitQuantity);
		this.unitPrice.set(unitPrice);
		this.unitSize=size;
	}
	public Item(String name, String unit,  double unitQuantity, double unitPrice,String size,String note) {
		this.name.set(name);
		this.unit.set(unit);
		this.unitQuantity.set(unitQuantity);
		this.unitPrice.set(unitPrice);
		this.unitSize=size;
		this.unitNote=note;
	}

	public final String getName() { return name.get(); }
	public final String getUnit() { return unit.get(); }
	public final double getUnitQuantity() { return unitQuantity.get(); }
	public final double getUnitPrice() { return unitPrice.get(); }

	public final void setName(String name) { this.name.set(name); }
	public final void setUnit(String unit) { this.unit.set(unit); }
	public final void setUnitQuantity(double unitQuantity) { this.unitQuantity.set(unitQuantity); }
	public final void setUnitPrice(double unitPrice) { this.unitPrice.set(unitPrice); }

	public StringProperty nameProperty() { return name; }
	public StringProperty unitProperty() { return unit; }
	public DoubleProperty unitQuantityProperty() { return unitQuantity; }
	public DoubleProperty unitPriceProperty() { return unitPrice; }

}


