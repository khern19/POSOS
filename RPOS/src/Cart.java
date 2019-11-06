import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.ArrayList;

public class Cart extends Application {
	Model model = new Model();
	View view = new View();
	double orginalTotal;


	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		model.loadData();		//this will load itemsObservableList from csv file
		Scene scene = new Scene(view.setupScene(), 1500, 970);  
		setupActions();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Coffee Shop");
		primaryStage.show();


	}

	ObjectBinding<Item> itemBinding = new ObjectBinding<Item>() {
		{
			super.bind(view.itemsComboBox.valueProperty());
		}
		@Override
		protected Item computeValue() {
			Item item; 
			if (view.itemsComboBox.getSelectionModel().getSelectedIndex() >= 0) 
				item = view.itemsComboBox.getSelectionModel().selectedItemProperty().get();
			else item = new Item();
			view.quantitySlider.setValue(0);
			return item;
		}
	};


	void setupActions() {
		//bind itemsTableView with data
		view.itemsTableView.setItems(model.cartObservableList);
		view.itemsComboBox.setItems(model.itemsObservableList); 

		//bind purchase units label with slider value using Fluent API
		view.purchasedUnitsValueLabel.textProperty().bind(Bindings.format("%.0f", view.quantitySlider.valueProperty()));

		//selecting item in itemsComboBox updates unit quantity and unit price labels

		view.unitValueLabel.textProperty().bind(Bindings.format("%.2f %s", Bindings.select(itemBinding, "unitQuantity"), Bindings.select(itemBinding, "unit")));
		view.unitPriceValueLabel.textProperty().bind(Bindings.format("$ %.2f", Bindings.select(itemBinding, "unitPrice")));

		//provide cell value factory for Price column in itemsTableView
		Callback<CellDataFeatures<ItemInCart, Double>, ObservableValue<Double>> callback = new Callback<CellDataFeatures<ItemInCart, Double>, ObservableValue<Double>>() {
			@Override
			public ObservableValue<Double> call(CellDataFeatures<ItemInCart, Double> param) {
				for(Item item : view.menuList) {
					if (item.getName().equalsIgnoreCase(param.getValue().getName())) {
						return (new SimpleDoubleProperty(param.getValue().getQuantity() * item.getUnitPrice())).asObject();
					}
				}
				return null;
			}
		};

		view.auLaitButton.setOnAction(event -> {

			Item item = new Item("Cafe au Latte","Cup",1.0,2.5);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.frenchPressButton.setOnAction((event) -> {
			Item item = new Item("Frecch Press","Cup",1.0,3.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.brewedButton.setOnAction((event) -> {
			Item item = new Item("Brewed Coffee","Cup",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.auLaitButton.setOnAction(event -> {
			Item item = new Item("Cafe au Latte","Cup",1.0,2.5);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.frenchPressButton.setOnAction((event) -> {
			Item item = new Item("Frecch Press","Cup",1.0,3.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.coldBrewButton.setOnAction((event) -> {
			Item item = new Item("Cold Brewed Coffee","Cup",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.icedCoffeeButton.setOnAction((event) -> {
			Item item = new Item("Iced Coffee","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.vcoldBrewButton.setOnAction((event) -> {
			Item item = new Item("Cold Brewed Coffee w/Cascara Cold Foam","Cup",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.icedCoffeeWButton.setOnAction((event) -> {
			Item item = new Item("Iced Coffee w/Vanilla","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.nitroButton.setOnAction((event) -> {
			Item item = new Item("Nitro Cold Brew","Cup",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.nitroWButton.setOnAction((event) -> {
			Item item = new Item("Nitro Cold Brew w/Vanilla","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});


		view.nitroCascaraButton.setOnAction((event) -> {
			Item item = new Item("Nitro Cold Brew w/Cascara Cold Foam","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.nitroWSweetButton.setOnAction((event) -> {
			Item item = new Item("Nitro Cold Brew w/Sweet Cream","Cup",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.blackTeaButton.setOnAction((event) -> {
			Item item = new Item("Black Tea","Cup",1.0,3.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.greenTeaButton.setOnAction((event) -> {
			Item item = new Item("Green Tea","Cup",1.0,3.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.herbalTeaButton.setOnAction((event) -> {
			Item item = new Item("Herbal Tea","Cup",1.0,3.5);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.oolongTeaButton.setOnAction((event) -> {
			Item item = new Item("Oolong Tea","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.chaiLatteButton.setOnAction((event) -> {
			Item item = new Item("Chai Latte","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.hotChocalateButton.setOnAction((event) -> {
			Item item = new Item("Hot Chocalate","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.lemonadeButton.setOnAction((event) -> {
			Item item = new Item("lemonade","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.fruitSmothieButton.setOnAction((event) -> {
			Item item = new Item("Fruit Smoothie","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.orangeJuiceButton.setOnAction((event) -> {
			Item item = new Item("Orange Juice","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.greenTeaIceButton .setOnAction((event) -> {
			Item item = new Item("Iced Green Tea","Cup",1.0,3.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.greenTeaLemonButton.setOnAction((event) -> {
			Item item = new Item("Green Tea Lemonade","Cup",1.0,3.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.iceChaiLatteButton.setOnAction((event) -> {
			Item item = new Item("Iced Chai Latte","Cup",1.0,3.5);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.matchaLatteButton.setOnAction((event) -> {
			Item item = new Item("Matcha Latte","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.iceMatchaLatteButton.setOnAction((event) -> {
			Item item = new Item("Iced Matcha Latte","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.matchaLemonButton.setOnAction((event) -> {
			Item item = new Item("Matcha Lemonade","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.whiteTeaButton.setOnAction((event) -> {
			Item item = new Item("White Tea","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.whiteTeaLemonButton.setOnAction((event) -> {
			Item item = new Item("White Tea Lemonade","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.peachTeaButton.setOnAction((event) -> {
			Item item = new Item("Peach Tea","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.pineppleTeaButton.setOnAction((event) -> {
			Item item = new Item("Pinapple Tea","Cup",1.0,3.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.strawberryTeaButton.setOnAction((event) -> {
			Item item = new Item("Strawberry Tea","Cup",1.0,3.5);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.berryTeaButton.setOnAction((event) -> {
			Item item = new Item("Mixed Berry Tea","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});


		view.espressButton.setOnAction((event) -> {
			Item item = new Item("Espresso","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.macchiatoButton.setOnAction((event) -> {
			Item item = new Item("Macchiato","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.conPannaButton.setOnAction((event) -> {
			Item item = new Item("Con Pana","Cup",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.cafeLatteButton.setOnAction((event) -> {
			Item item = new Item("Cafe Latte","Cup",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.classicCapButton.setOnAction((event) -> {
			Item item = new Item("Classic Cappuccino","Cup",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.cappuccinoButton.setOnAction((event) -> {
			Item item = new Item("Cappuccino","Cup",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.mochaButton.setOnAction((event) -> {
			Item item = new Item("Mocha Latte","Cup",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.caramelButton.setOnAction((event) -> {
			Item item = new Item("Caramel Latte","Cup",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.vanillaButton.setOnAction((event) -> {
			Item item = new Item("Vanilla Latte","Cup",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.mielButton.setOnAction((event) -> {
			Item item = new Item("Cafe miel","Cup",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.americanoButton.setOnAction((event) -> {
			Item item = new Item("Cafe americano","Cup",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.skinnyMochaButton.setOnAction((event) -> {
			Item item = new Item("Skinny Mocha","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.blondeButton.setOnAction((event) -> {
			Item item = new Item("Blonde Macchiato","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.blondeCaramelButton.setOnAction((event) -> {
			Item item = new Item("Blonde Caramel Cloud Macchiato","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.blondeCinnamonButton.setOnAction((event) -> {
			Item item = new Item("Blonde Cinnamon Cloud Macchiato","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.blondeLatteButton.setOnAction((event) -> {
			Item item = new Item("Blonde Caffe Latte","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.blondeAmericanoButton.setOnAction((event) -> {
			Item item = new Item("Blonde Caffa Americano","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.blondeVanillaButton.setOnAction((event) -> {
			Item item = new Item("Blonde Vanilla Latte","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.flatWhiteButton.setOnAction((event) -> {
			Item item = new Item("Blonde Flat White","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.whiteChocalateButton.setOnAction((event) -> {
			Item item = new Item("White Chocolate Mocha","Cup",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.blueMuffinButton.setOnAction((event) -> {
			Item item = new Item("Blueberry Muffin","piece",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.croissantButterButton.setOnAction((event) -> {
			Item item = new Item("Butter Croissant","piece",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.bagelButton.setOnAction((event) -> {
			Item item = new Item("Plain Bagel","piece",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.cinnamonButton.setOnAction((event) -> {
			Item item = new Item("Cinnamon Roll","piece",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.tartButton.setOnAction((event) -> {
			Item item = new Item("Fruit Tart","piece",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.eclairButton.setOnAction((event) -> {
			Item item = new Item("Chocalate eclair","Piece",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.puffButton.setOnAction((event) -> {
			Item item = new Item("Strawberry cream puff","Whole",1.0,2.0);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.bagelVeganButton.setOnAction((event) -> {
			Item item = new Item("Vegan Bagel","Whole",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.bagelCinRasianButton.setOnAction((event) -> {
			Item item = new Item("Cinnamon Raisan Bage","Whole",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.almondCroissantButton.setOnAction((event) -> {
			Item item = new Item("Almond Croissant","Piece",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.croissantChocoButton.setOnAction((event) -> {
			Item item = new Item("Chocolate Croissant","Piece",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.bithdayPopButton.setOnAction((event) -> {
			Item item = new Item("Birthday Cake Pop","Whole",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.lemonPopButton.setOnAction((event) -> {
			Item item = new Item("Lemon Cake Pop","Whole",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.chocoPopButton.setOnAction((event) -> {
			Item item = new Item("Chocolate Cake Pop","Whole",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.bananaButton.setOnAction((event) -> {
			Item item = new Item("Banana Bread","Piece",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.sconeVanillaButton.setOnAction((event) -> {
			Item item = new Item("Vanilla Bean Scone","Piece",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.sconeStrawberryButton.setOnAction((event) -> {
			Item item = new Item("Strawberry Yogurt Scone","Piece",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.lemonCakeButton.setOnAction((event) -> {
			Item item = new Item("Lemon Cake","Piece",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.brownieButton.setOnAction((event) -> {
			Item item = new Item("Brownie","Piece",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.sugarCookieButton.setOnAction((event) -> {
			Item item = new Item("Sugar Cookie","Whole",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.coffeeCakeButton.setOnAction((event) -> {
			Item item = new Item("Coffe Cake","Piece",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.donutButton.setOnAction((event) -> {
			Item item = new Item("Donut","Whole",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.sconeBlueButton.setOnAction((event) -> {
			Item item = new Item("Blueberry Scone","Piece",1.0,2.2);
			view.menuList.add(item);

			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});



		//set rate columnn's call-back for factory method

		view.rateColumn.setCellValueFactory(callback);
		//view.sizeColumn.setCellValueFactory(callback2);



		//event handler for add button creates new ItemInCart with currently selected item'name and purchase qty 
		//and adds it to cartObservableList
		//it also moves the table selection to the last item just added

		view.auLaitButton.setOnAction(event -> {
			
			Item item = new Item("Cafe au Latte","Cup",1.0,2.5);
			view.menuList.add(item);
			
			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});
		
		view.frenchPressButton.setOnAction((event) -> {
			Item item = new Item("Frecch Press","Cup",1.0,3.0);
			view.menuList.add(item);
			
			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});

		view.brewedButton.setOnAction((event) -> {
			Item item = new Item("Brewed Coffee","Cup",1.0,2.0);
			view.menuList.add(item);
			
			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue());
			model.cartObservableList.add(shoppingCartItem);
		});
		DoubleBinding subtotalBinding = new DoubleBinding() {
			{
				super.bind(model.cartObservableList);
			}

			@Override
			protected double computeValue() {
				double subtotal = 0;
				if (model.cartObservableList.size() > 0)
					for (int row = 0; row < model.cartObservableList.size(); row++)
						subtotal += (double)view.itemsTableView.getColumns().get(3).getCellObservableValue(row).getValue();
				return subtotal;
			}

		};

		//bind totalValueLabel's textProperty to totalBinding
		view.subtotalValueLabel.textProperty().bind(Bindings.format("%.2f", subtotalBinding));

		DoubleBinding taxBinding = new DoubleBinding() {
			{
				super.bind(model.cartObservableList);
			}

			@Override
			protected double computeValue() {
				double taxtotal = 0;
				if (model.cartObservableList.size() > 0)
					for (int row = 0; row < model.cartObservableList.size(); row++)
						taxtotal += (double)view.itemsTableView.getColumns().get(3).getCellObservableValue(row).getValue() * 0.10;
				return taxtotal;
			}

		};

		//bind totalValueLabel's textProperty to totalBinding
		view.taxValueLabel.textProperty().bind(Bindings.format("%.2f", taxBinding));

		DoubleBinding totalBinding = new DoubleBinding() {
			{
				super.bind(model.cartObservableList);
			}

			@Override
			protected double computeValue() {
				double total = 0;
				double taxTotal = 0;

				if (model.cartObservableList.size() > 0)
					for (int row = 0; row < model.cartObservableList.size(); row++)
						total += (double)view.itemsTableView.getColumns().get(3).getCellObservableValue(row).getValue();

				if (model.cartObservableList.size() > 0)
					for (int row = 0; row < model.cartObservableList.size(); row++)
						taxTotal += (double)view.itemsTableView.getColumns().get(3).getCellObservableValue(row).getValue() * 0.10;

				double totalDue = total + taxTotal;

				return totalDue;

			}

		};


		//bind totalValueLabel's textProperty to totalBinding
		view.balanceValueLabel.textProperty().bind(Bindings.format("%.2f", totalBinding));
		view.totalValueLabel.textProperty().bind(Bindings.format("%.2f", totalBinding));

		view.payButton.setOnAction(event ->{
			Scene secondScene = new Scene(view.payLayout(), 300, 150);

			// New window (Stage)
			Stage newWindow = new Stage();
			newWindow.setTitle("Payment Method");
			newWindow.setScene(secondScene);

			newWindow.show();
		});

		view.cashButton.setOnAction(event ->{
			Scene scene = new Scene(view.cashLayout(), 180, 250);
			view.cal.setText("");
			// New window (Stage)
			Stage newWindow = new Stage();
			newWindow.setTitle("Paying Cash");
			newWindow.setScene(scene);

			newWindow.show();
		});

		view.userButton.setOnAction(event ->{
			Scene secondScene = new Scene(view.userLayout(), 300, 150);

			// New window (Stage)
			Stage newWindow = new Stage();
			newWindow.setTitle("User Options");
			newWindow.setScene(secondScene);

			newWindow.show();
		});

		view.logoutButton.setOnAction(event ->{
			System.exit(0);
		});

		view.discountButton.setOnAction(event ->{
			Scene secondScene = new Scene(view.discountLayout(), 500, 300);

			orginalTotal = Double.parseDouble(view.totalValueLabel.getText());
			// New window (Stage)
			Stage newWindow = new Stage();
			newWindow.setTitle("Discount");
			newWindow.setScene(secondScene);

			newWindow.show();
		});

		//Calculator
		view.b0.setOnAction(event ->{
			view.cal.setText(view.cal.getText() + "0");
		});
		view.b1.setOnAction(event ->{
			view.cal.setText(view.cal.getText() + "1");
		});
		view.b2.setOnAction(event ->{
			view.cal.setText(view.cal.getText() + "2");
		});
		view.b3.setOnAction(event ->{
			view.cal.setText(view.cal.getText() + "3");
		});
		view.b4.setOnAction(event ->{
			view.cal.setText(view.cal.getText() + "4");
		});
		view.b5.setOnAction(event ->{
			view.cal.setText(view.cal.getText() + "5");
		});
		view.b6.setOnAction(event ->{
			view.cal.setText(view.cal.getText() + "6");
		});
		view.b7.setOnAction(event ->{
			view.cal.setText(view.cal.getText() + "7");
		});
		view.b8.setOnAction(event ->{
			view.cal.setText(view.cal.getText() + "8");
		});
		view.b9.setOnAction(event ->{
			view.cal.setText(view.cal.getText() + "9");
		});
		view.bDot.setOnAction(event ->{
			view.cal.setText(view.cal.getText() + ".");
		});
		view.call.setOnAction(event ->{
			double payIn = Double.parseDouble(view.cal.getText());
			double payNeed = Double.parseDouble(view.totalValueLabel.getText());
			double payOut;

			if(payNeed != 0 && payIn >= payNeed) {

				payOut = payIn - payNeed;

				view.change.setText(Double.toString(payOut) + " Dollars");
				model.cartObservableList.removeAll(model.cartObservableList);
				Scene secondScene = new Scene(view.finalLayout(), 300, 150);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Cash payment");
				newWindow.setScene(secondScene);

				newWindow.show();
			}
		});

		//Cancel Button
		view.cancelButton.setOnAction(event ->{
			view.totalValueLabel.textProperty().bind(Bindings.format("%.2f", totalBinding));
			view.percentage.setText("");
		});
		//Discount
		view.employeeButton.setOnAction(event ->{
			double total = Double.parseDouble(view.totalValueLabel.getText());
			total = total * 0.7;
			view.totalValueLabel.textProperty().bind(Bindings.format("%.2f", total));
			view.percentage.setText("With 30% off");
		});

		view.studentButton.setOnAction(event ->{
			double total = Double.parseDouble(view.totalValueLabel.getText());
			total = total * 0.9;
			view.totalValueLabel.textProperty().bind(Bindings.format("%.2f", total));
			view.percentage.setText("With 10% off");
		});

		view.happyBDayButton.setOnAction(event ->{
			double total = Double.parseDouble(view.totalValueLabel.getText());
			total = total * 0.85;
			view.totalValueLabel.textProperty().bind(Bindings.format("%.2f", total));
			view.percentage.setText("With 15% off");
		});

		//event handler for remove button
		//checks the current selected index
		//if it is >= 0, it removes the item at that index from cartObservableList
		view.removeButton.setOnAction(event -> {
			int index = view.itemsTableView.getSelectionModel().getFocusedIndex();
			if (model.cartObservableList.size() > index)
				model.cartObservableList.remove(index);
			view.menuList.remove(index);
			if (model.cartObservableList.size() == 0) view.itemsComboBox.getSelectionModel().clearSelection();
		});

		view.clearButton.setOnAction((event) -> {
			model.cartObservableList.removeAll(model.cartObservableList);
			view.totalValueLabel.textProperty().bind(Bindings.format("%.2f", totalBinding));
			view.percentage.setText("");
		});

		//listener for item-selection in itemsTableView updates the image, item in combo-box, and qty in quantitySlider
		//it looks for the selected item in the tableView in itemsObservableList, sets itemComboBox to that index, and
		//quantitySlider to the newValue's quantity.
		view.itemsTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				int index = 0;
				for (Item item : model.itemsObservableList) {
					if (item.getName().equals(newValue.getName())) { 
						view.itemsComboBox.getSelectionModel().select(index);
						view.quantitySlider.setValue(newValue.getQuantity());
						break;
					}
					index++;
				}
			}
		});

		//working secondary screen with option for addons and cup size
		view.addButton.setOnAction(event -> {

			//temp arraylist and string
			ArrayList<String> tempArr = new ArrayList<>();
			String temp="";


			//loops through all our buttons in the secondary list
			for(int i=0; i<view.list.size();i++) {
				//if its a checkbox and it is selected. Add its string value to the temp array
				if(view.list.get(i) instanceof CheckBox ) {
					if (((CheckBox) view.list.get(i)).isSelected()) {
						tempArr.add(((CheckBox) view.list.get(i)).getText());
					}
				}
				//if its a textfield and its not empty. Add its string value to the temp array
				else if(view.list.get(i) instanceof TextField){
					if(((TextField) view.list.get(i)).getText() !=null){
						tempArr.add(((TextField) view.list.get(i)).getText());

					}

				}
			}



			//make that temp array into a single string with commas seperating it
			temp = String.join(", ",tempArr);

			//get the size of the cup. its a radio button so only one size can be selected at a time. Large is automatically selected
			RadioButton selectedRadioButton = (RadioButton) view.toggleGroup.getSelectedToggle();

			//create the item object with the seconday options and add it to our cart
			Item item = new Item("Brewed Coffee", "Cup", 1.0, 2.5,selectedRadioButton.getText(),temp);
			view.menuList.add(item);

			//create the shopping cart item
			ItemInCart shoppingCartItem = new ItemInCart(item.getName(), view.quantitySlider.getValue(),item.unitSize,item.unitNote);
			model.cartObservableList.add(shoppingCartItem);


		});

		//event handler for remove button
		//checks the current selected index
		//if it is >= 0, it removes the item at that index from cartObservableList


		view.coffeeButton.setOnAction(event -> {

			view.brewedButton.setVisible(true);
			view.auLaitButton.setVisible(true);
			view.frenchPressButton.setVisible(true);
			view.icedCoffeeButton.setVisible(true);
			view.coldBrewButton.setVisible(true);
			view.vcoldBrewButton.setVisible(true);
			view.icedCoffeeWButton.setVisible(true);
			view.nitroButton.setVisible(true);
			view.nitroWButton.setVisible(true);
			view.nitroCascaraButton.setVisible(true);
			view.nitroWSweetButton.setVisible(true);



			view.blackTeaButton.setVisible(false);
			view.greenTeaButton.setVisible(false);
			view.herbalTeaButton.setVisible(false);
			view.oolongTeaButton.setVisible(false);
			view.chaiLatteButton.setVisible(false);
			view.hotChocalateButton.setVisible(false);
			view.lemonadeButton.setVisible(false);
			view.fruitSmothieButton.setVisible(false);
			view.orangeJuiceButton.setVisible(false);
			view.greenTeaIceButton.setVisible(false);
			view.greenTeaLemonButton.setVisible(false);
			view.iceChaiLatteButton.setVisible(false);
			view.matchaLatteButton.setVisible(false);
			view.iceMatchaLatteButton.setVisible(false);
			view.matchaLemonButton.setVisible(false);
			view.whiteTeaButton.setVisible(false);
			view.whiteTeaLemonButton.setVisible(false);
			view.peachTeaButton.setVisible(false);
			view.pineppleTeaButton.setVisible(false);
			view.strawberryTeaButton.setVisible(false);
			view.berryTeaButton.setVisible(false);
			view.espressButton.setVisible(false);
			view.macchiatoButton.setVisible(false);
			view.conPannaButton.setVisible(false);
			view.cafeLatteButton.setVisible(false);
			view.classicCapButton.setVisible(false);
			view.cappuccinoButton.setVisible(false);
			view.mochaButton.setVisible(false);
			view.caramelButton.setVisible(false);
			view.vanillaButton.setVisible(false);
			view.mielButton.setVisible(false);
			view.americanoButton.setVisible(false);
			view.caramelMacchiatoButton.setVisible(false);
			view.cinnamonMacchiatoButton.setVisible(false);
			view.skinnyMochaButton.setVisible(false);
			view.blondeButton.setVisible(false);
			view.blondeCaramelButton.setVisible(false);
			view.blondeCinnamonButton.setVisible(false);
			view.blondeLatteButton.setVisible(false);
			view.blondeAmericanoButton.setVisible(false);
			view.blondeVanillaButton.setVisible(false);
			view.flatWhiteButton.setVisible(false);
			view.whiteChocalateButton.setVisible(false);
			view.almondCroissantButton.setVisible(false);
			view.croissantChocoButton.setVisible(false);
			view.bagelVeganButton.setVisible(false);
			view.blueMuffinButton.setVisible(false);
			view.croissantButterButton.setVisible(false);
			view.bagelButton.setVisible(false);
			view.cinnamonButton.setVisible(false);
			view.tartButton.setVisible(false);
			view.eclairButton.setVisible(false);
			view.puffButton.setVisible(false);
			view.bagelCinRasianButton.setVisible(false);
			view.bithdayPopButton.setVisible(false);
			view.lemonPopButton.setVisible(false);
			view.chocoPopButton.setVisible(false);
			view.bananaButton.setVisible(false);
			view.sconeVanillaButton.setVisible(false);
			view.sconeStrawberryButton.setVisible(false);
			view.sconeBlueButton.setVisible(false);
			view.lemonCakeButton.setVisible(false);
			view.brownieButton.setVisible(false);
			view.sugarCookieButton.setVisible(false);
			view.coffeeCakeButton.setVisible(false);
			view.donutButton.setVisible(false);



		});

		view.noncoffeeButton.setOnAction(event -> {

			view.blackTeaButton.setVisible(true);
			view.greenTeaButton.setVisible(true);
			view.herbalTeaButton.setVisible(true);
			view.oolongTeaButton.setVisible(true);
			view.chaiLatteButton.setVisible(true);
			view.hotChocalateButton.setVisible(true);
			view.lemonadeButton.setVisible(true);
			view.fruitSmothieButton.setVisible(true);
			view.orangeJuiceButton.setVisible(true);
			view.greenTeaIceButton.setVisible(true);
			view.greenTeaLemonButton.setVisible(true);
			view.iceChaiLatteButton.setVisible(true);
			view.matchaLatteButton.setVisible(true);
			view.iceMatchaLatteButton.setVisible(true);
			view.matchaLemonButton.setVisible(true);
			view.whiteTeaButton.setVisible(true);
			view.whiteTeaLemonButton.setVisible(true);
			view.peachTeaButton.setVisible(true);
			view.pineppleTeaButton.setVisible(true);
			view.strawberryTeaButton.setVisible(true);
			view.berryTeaButton.setVisible(true);

			view.coldBrewButton.setVisible(false);
			view.vcoldBrewButton.setVisible(false);
			view.icedCoffeeWButton.setVisible(false);
			view.nitroButton.setVisible(false);
			view.nitroWButton.setVisible(false);
			view.nitroCascaraButton.setVisible(false);
			view.nitroWSweetButton.setVisible(false);
			view.brewedButton.setVisible(false);
			view.auLaitButton.setVisible(false);
			view.frenchPressButton.setVisible(false);
			view.icedCoffeeButton.setVisible(false);
			view.espressButton.setVisible(false);
			view.macchiatoButton.setVisible(false);
			view.conPannaButton.setVisible(false);
			view.cafeLatteButton.setVisible(false);
			view.classicCapButton.setVisible(false);
			view.cappuccinoButton.setVisible(false);
			view.mochaButton.setVisible(false);
			view.caramelButton.setVisible(false);
			view.vanillaButton.setVisible(false);
			view.mielButton.setVisible(false);
			view.americanoButton.setVisible(false);
			view.caramelMacchiatoButton.setVisible(false);
			view.cinnamonMacchiatoButton.setVisible(false);
			view.skinnyMochaButton.setVisible(false);
			view.blondeButton.setVisible(false);
			view.blondeCaramelButton.setVisible(false);
			view.blondeCinnamonButton.setVisible(false);
			view.blondeLatteButton.setVisible(false);
			view.blondeAmericanoButton.setVisible(false);
			view.blondeVanillaButton.setVisible(false);
			view.flatWhiteButton.setVisible(false);
			view.whiteChocalateButton.setVisible(false);
			view.almondCroissantButton.setVisible(false);
			view.croissantChocoButton.setVisible(false);
			view.bagelVeganButton.setVisible(false);
			view.blueMuffinButton.setVisible(false);
			view.croissantButterButton.setVisible(false);
			view.bagelButton.setVisible(false);
			view.cinnamonButton.setVisible(false);
			view.tartButton.setVisible(false);
			view.eclairButton.setVisible(false);
			view.puffButton.setVisible(false);
			view.bagelCinRasianButton.setVisible(false);
			view.bithdayPopButton.setVisible(false);
			view.lemonPopButton.setVisible(false);
			view.chocoPopButton.setVisible(false);
			view.bananaButton.setVisible(false);
			view.sconeVanillaButton.setVisible(false);
			view.sconeStrawberryButton.setVisible(false);
			view.sconeBlueButton.setVisible(false);
			view.lemonCakeButton.setVisible(false);
			view.brownieButton.setVisible(false);
			view.sugarCookieButton.setVisible(false);
			view.coffeeCakeButton.setVisible(false);
			view.donutButton.setVisible(false);


		});

		view.espressoButton.setOnAction(event -> {

			view.espressButton.setVisible(true);
			view.macchiatoButton.setVisible(true);
			view.conPannaButton.setVisible(true);
			view.cafeLatteButton.setVisible(true);
			view.classicCapButton.setVisible(true);
			view.cappuccinoButton.setVisible(true);
			view.mochaButton.setVisible(true);
			view.caramelButton.setVisible(true);
			view.vanillaButton.setVisible(true);
			view.mielButton.setVisible(true);
			view.americanoButton.setVisible(true);
			view.caramelMacchiatoButton.setVisible(true);
			view.cinnamonMacchiatoButton.setVisible(true);
			view.skinnyMochaButton.setVisible(true);
			view.blondeButton.setVisible(true);
			view.blondeCaramelButton.setVisible(true);
			view.blondeCinnamonButton.setVisible(true);
			view.blondeLatteButton.setVisible(true);
			view.blondeAmericanoButton.setVisible(true);
			view.blondeVanillaButton.setVisible(true);
			view.flatWhiteButton.setVisible(true);
			view.whiteChocalateButton.setVisible(true);


			view.coldBrewButton.setVisible(false);
			view.vcoldBrewButton.setVisible(false);
			view.icedCoffeeWButton.setVisible(false);
			view.nitroButton.setVisible(false);
			view.nitroWButton.setVisible(false);
			view.nitroCascaraButton.setVisible(false);
			view.nitroWSweetButton.setVisible(false);
			view.brewedButton.setVisible(false);
			view.auLaitButton.setVisible(false);
			view.frenchPressButton.setVisible(false);
			view.icedCoffeeButton.setVisible(false);
			view.blackTeaButton.setVisible(false);
			view.greenTeaButton.setVisible(false);
			view.herbalTeaButton.setVisible(false);
			view.oolongTeaButton.setVisible(false);
			view.chaiLatteButton.setVisible(false);
			view.hotChocalateButton.setVisible(false);
			view.lemonadeButton.setVisible(false);
			view.fruitSmothieButton.setVisible(false);
			view.orangeJuiceButton.setVisible(false);
			view.greenTeaIceButton.setVisible(false);
			view.greenTeaLemonButton.setVisible(false);
			view.iceChaiLatteButton.setVisible(false);
			view.matchaLatteButton.setVisible(false);
			view.iceMatchaLatteButton.setVisible(false);
			view.matchaLemonButton.setVisible(false);
			view.whiteTeaButton.setVisible(false);
			view.whiteTeaLemonButton.setVisible(false);
			view.peachTeaButton.setVisible(false);
			view.pineppleTeaButton.setVisible(false);
			view.strawberryTeaButton.setVisible(false);
			view.berryTeaButton.setVisible(false);
			view.almondCroissantButton.setVisible(false);
			view.croissantChocoButton.setVisible(false);
			view.bagelVeganButton.setVisible(false);
			view.blueMuffinButton.setVisible(false);
			view.croissantButterButton.setVisible(false);
			view.bagelButton.setVisible(false);
			view.cinnamonButton.setVisible(false);
			view.tartButton.setVisible(false);
			view.eclairButton.setVisible(false);
			view.puffButton.setVisible(false);
			view.bagelCinRasianButton.setVisible(false);
			view.bithdayPopButton.setVisible(false);
			view.lemonPopButton.setVisible(false);
			view.chocoPopButton.setVisible(false);
			view.bananaButton.setVisible(false);
			view.sconeVanillaButton.setVisible(false);
			view.sconeStrawberryButton.setVisible(false);
			view.sconeBlueButton.setVisible(false);
			view.lemonCakeButton.setVisible(false);
			view.brownieButton.setVisible(false);
			view.sugarCookieButton.setVisible(false);
			view.coffeeCakeButton.setVisible(false);
			view.donutButton.setVisible(false);



		});

		view.pastriesButton.setOnAction(event -> {

			view.blueMuffinButton.setVisible(true);
			view.croissantButterButton.setVisible(true);
			view.bagelButton.setVisible(true);
			view.bagelVeganButton.setVisible(true);
			view.cinnamonButton.setVisible(true);
			view.tartButton.setVisible(true);
			view.eclairButton.setVisible(true);
			view.puffButton.setVisible(true);
			view.bagelCinRasianButton.setVisible(true);
			view.bithdayPopButton.setVisible(true);
			view.lemonPopButton.setVisible(true);
			view.chocoPopButton.setVisible(true);
			view.bananaButton.setVisible(true);
			view.sconeVanillaButton.setVisible(true);
			view.sconeStrawberryButton.setVisible(true);
			view.sconeBlueButton.setVisible(true);
			view.lemonCakeButton.setVisible(true);
			view.brownieButton.setVisible(true);
			view.sugarCookieButton.setVisible(true);
			view.coffeeCakeButton.setVisible(true);
			view.donutButton.setVisible(true);
			view.almondCroissantButton.setVisible(true);
			view.croissantChocoButton.setVisible(true);

			view.brewedButton.setVisible(false);
			view.auLaitButton.setVisible(false);
			view.frenchPressButton.setVisible(false);
			view.icedCoffeeButton.setVisible(false);
			view.blackTeaButton.setVisible(false);
			view.greenTeaButton.setVisible(false);
			view.herbalTeaButton.setVisible(false);
			view.oolongTeaButton.setVisible(false);
			view.chaiLatteButton.setVisible(false);
			view.hotChocalateButton.setVisible(false);
			view.lemonadeButton.setVisible(false);
			view.fruitSmothieButton.setVisible(false);
			view.orangeJuiceButton.setVisible(false);
			view.greenTeaIceButton.setVisible(false);
			view.greenTeaLemonButton.setVisible(false);
			view.iceChaiLatteButton.setVisible(false);
			view.matchaLatteButton.setVisible(false);
			view.iceMatchaLatteButton.setVisible(false);
			view.matchaLemonButton.setVisible(false);
			view.whiteTeaButton.setVisible(false);
			view.whiteTeaLemonButton.setVisible(false);
			view.peachTeaButton.setVisible(false);
			view.pineppleTeaButton.setVisible(false);
			view.strawberryTeaButton.setVisible(false);
			view.berryTeaButton.setVisible(false);
			view.espressButton.setVisible(false);
			view.macchiatoButton.setVisible(false);
			view.conPannaButton.setVisible(false);
			view.cafeLatteButton.setVisible(false);
			view.classicCapButton.setVisible(false);
			view.cappuccinoButton.setVisible(false);
			view.mochaButton.setVisible(false);
			view.caramelButton.setVisible(false);
			view.vanillaButton.setVisible(false);
			view.mielButton.setVisible(false);
			view.americanoButton.setVisible(false);
			view.caramelMacchiatoButton.setVisible(false);
			view.cinnamonMacchiatoButton.setVisible(false);
			view.skinnyMochaButton.setVisible(false);
			view.blondeButton.setVisible(false);
			view.blondeCaramelButton.setVisible(false);
			view.blondeCinnamonButton.setVisible(false);
			view.blondeLatteButton.setVisible(false);
			view.blondeAmericanoButton.setVisible(false);
			view.blondeVanillaButton.setVisible(false);
			view.flatWhiteButton.setVisible(false);
			view.whiteChocalateButton.setVisible(false);


		});

		
			view.brewedButton.setOnAction(event ->{

			 
            Scene secondScene = new Scene(view.secondaryLayout(), 500, 300);

            // New window (Stage)
            Stage newWindow = new Stage();
            newWindow.setTitle("Second Stage");
            newWindow.setScene(secondScene);

            newWindow.show();

		});
		
	}
}
