
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class View {
	ComboBox<Item> itemsComboBox = new ComboBox<>();  //the drop down will show item-names from itemsMasterList
	Label unitValueLabel = new Label();
	Label unitPriceValueLabel = new Label();
	List<Object> list = new ArrayList<Object>();

	Label subtotalValueLabel = new Label();
	Label taxValueLabel = new Label();
	Label balanceValueLabel = new Label();
	Label totalValueLabel = new Label();

	VBox vbCheckButtons = new VBox();

	ObservableList<Item> menuList = FXCollections.observableArrayList();
	
	Slider quantitySlider = new Slider(1, 10, 1);  //min, max, current
	Label purchasedUnitsValueLabel = new Label("0");

	
	//Button addButton = new Button("Add to Cart");
	Button coffeeButton = new Button("Coffee");
	Button noncoffeeButton = new Button("Non-Coffee");
	Button espressoButton = new Button("Espresso");
	Button pastriesButton = new Button("Pastries");

	Button brewedButton = new Button("Brewed Coffee");
	Button nitroButton = new Button("Nitro Cold Brew");
	Button nitroWButton = new Button("Nitro Cold Brew with Vanilla");
	Button nitroCascaraButton = new Button("Nitro Cold Brew with Cascara Cold Foam");
	Button nitroWSweetButton = new Button("Nitro Cold Brew with Sweet Cream");
	Button coldBrewButton = new Button("Cold Brew");
	Button vcoldBrewButton = new Button("Cold Brew with Cascara Cold Foam");
	Button auLaitButton = new Button("Cafe au latte");
	Button frenchPressButton = new Button("French press");
	Button icedCoffeeButton = new Button("Iced coffee");
	Button icedCoffeeWButton = new Button("Iced coffee with Vanilla");

	Button blackTeaButton = new Button("Black Tea");
	Button greenTeaButton = new Button("Green Tea");
	Button greenTeaIceButton = new Button("Iced Green Tea");
	Button greenTeaLemonButton = new Button("Green Tea Lemonade");
	Button herbalTeaButton = new Button("Herbal Tea");
	Button oolongTeaButton = new Button("Oolong Tea");
	Button chaiLatteButton = new Button("Chai Latte");
	Button iceChaiLatteButton = new Button("Iced Chai Latte");
	Button matchaLatteButton = new Button("Matcha Latte");
	Button iceMatchaLatteButton = new Button("Iced Matcha Latte");
	Button matchaLemonButton = new Button("Matcha Lemonade");
	Button whiteTeaButton = new Button("White Tea");
	Button whiteTeaLemonButton = new Button("White Tea Lemonade");
	Button peachTeaButton = new Button("Peach Tea");
	Button pineppleTeaButton = new Button("Pinapple Tea");
	Button strawberryTeaButton = new Button("Strawberry Tea");
	Button berryTeaButton = new Button("Mixed Berry Tea");
	Button hotChocalateButton = new Button("Hor Chocalate");
	Button lemonadeButton = new Button("Lemonade");
	Button fruitSmothieButton = new Button("Fruit Smoothie");
	Button orangeJuiceButton = new Button("Orange Juice");

	Button espressButton = new Button("Espresso");
	Button macchiatoButton = new Button("Macchiato");
	Button caramelMacchiatoButton = new Button("Caramel Macchiato");
	Button cinnamonMacchiatoButton = new Button("Cinnamon Macchiato");
	Button conPannaButton = new Button("Con Pana");
	Button cafeLatteButton = new Button("Cafe Latte");
	Button classicCapButton = new Button("Classic Cappuccino");
	Button cappuccinoButton = new Button("Cappuccino");
	Button mochaButton = new Button("Mocha Latte");
	Button caramelButton = new Button("Caramel Latte");
	Button vanillaButton = new Button("Vanilla Latte");
	Button mielButton = new Button("Cafe miel");
	Button americanoButton = new Button("Cafe americano");
	Button skinnyMochaButton = new Button("Skinny Mocha");
	Button blondeButton = new Button("Blonde Macchiato");
	Button blondeCaramelButton = new Button("Blonde Caramel Cloud Macchiato");
	Button blondeCinnamonButton = new Button("Blonde Cinnamon Cloud Macchiato");
	Button blondeLatteButton = new Button("Blonde Caffe Latte");
	Button blondeAmericanoButton = new Button("Blonde Caffa Americano");
	Button blondeVanillaButton = new Button("Blonde Vanilla Latte");
	Button flatWhiteButton = new Button("Blonde Flat White");
	Button whiteChocalateButton = new Button("White Chocolate Mocha");

	Button blueMuffinButton = new Button("Blueberry Muffin");
	Button croissantButterButton = new Button("Butter Croissant");
	Button bagelButton = new Button("Bagel");
	Button bagelVeganButton = new Button("Vegan Bagel");
	Button bagelCinRasianButton = new Button("Cinnamon Rasian Bagel");
	Button almondCroissantButton = new Button("Almond Croissant");
	Button cinnamonButton = new Button("Cinnamon Roll");
	Button tartButton = new Button("Fruit Tart");
	Button eclairButton = new Button("Chocalate eclair");
	Button puffButton = new Button("Strawberry cream puff");
	Button croissantChocoButton = new Button("Chcalate Croissant");
	Button bithdayPopButton = new Button("Bithdat Cake Pop");
	Button lemonPopButton = new Button("Lemon Cake Pop");
	Button chocoPopButton = new Button("Chocalate Cake Pop");
	Button bananaButton = new Button("Banana Bread");
	Button sconeVanillaButton = new Button("Vanilla Bean scone");
	Button sconeStrawberryButton = new Button("Strawberry Yogurt Scone");
	Button lemonCakeButton = new Button("Lemon Cake");
	Button brownieButton = new Button("Brownie");
	Button sugarCookieButton = new Button("Sugar Cookie");
	Button coffeeCakeButton = new Button("Coffee cake");
	Button donutButton = new Button("Donut");
	Button sconeBlueButton = new Button("Blueberry Scone");

	//Pay Function
	Button payButton = new Button("Pay");
	Button cashButton = new Button("Cash");
	Button cardButton = new Button("Card");
	//User Function
	Button userButton = new Button("User");
	Button loginButton = new Button("Log In");
	Button logoutButton = new Button("log Out");
	//Discount Function
	Button discountButton = new Button("Discount");
	Button employeeButton = new Button("Empolyee 30% off");
	Button studentButton = new Button("Student 10% off");
	Button happyBDayButton = new Button("Birthday 15% off");
	Button cancelButton = new Button("Cancel Discount");


	Button clearButton = new Button("Clear");
	Button removeButton = new Button("Remove");

	//Calculator
	Button b0 = new Button("0");
	Button b1 = new Button("1");
	Button b2 = new Button("2");
	Button b3 = new Button("3");
	Button b4 = new Button("4");
	Button b5 = new Button("5");
	Button b6 = new Button("6");
	Button b7 = new Button("7");
	Button b8 = new Button("8");
	Button b9 = new Button("9");
	Button bDot = new Button(".");
	TextField cal = new TextField();
	Button call = new Button("Checkout");
	Label thank = new Label("Thanks! Your changed is:");
	Label change = new Label();
	Label percentage = new Label();






	TableView<ItemInCart> itemsTableView = new TableView<>();
	TableColumn<ItemInCart, Double> rateColumn = new TableColumn<>("Purchase price");
	//TableColumn<ItemInCart, String> sizeColumn = new TableColumn<>("Size");
	ToggleGroup toggleGroup = new ToggleGroup();




	//2nd Window buttons and check box
	CheckBox cbEspressoShot = new CheckBox("Espresso Shot");
	CheckBox cbWHip = new CheckBox("Whip Cream");
	CheckBox cbBoba = new CheckBox("Boba");
	CheckBox cbChocolate = new CheckBox("Chocolate");
	CheckBox cbIce = new CheckBox("Iceed");
	CheckBox cbLightIce = new CheckBox("Light Ice");
	CheckBox cbAlmondMilk = new CheckBox("Almond Milk");
	CheckBox cbShotFatFreeMilk = new CheckBox("Fat Free Milk");
	TextField request = new TextField("Special Request");


	Button addButton = new Button("Add");
	//Button cancelButton = new Button("Cancel");

	final ToggleGroup group = new ToggleGroup();

	RadioButton rb1 = new RadioButton("Home");


	RadioButton rb2 = new RadioButton("Calendar");

	RadioButton rb3 = new RadioButton("Contacts");



	@SuppressWarnings("unchecked")
	BorderPane setupScene() {


		BorderPane root = new BorderPane();

		GridPane bottomGrid = new GridPane();
		SplitPane splitPane = new SplitPane();
		//root.setBottom(bottomGrid);
		
		/**setup topGrid */
		bottomGrid.setVgap(10);
		bottomGrid.setHgap(10);

		//create fixed labels
		Label unitLabel = new Label("Item");
		Label pricePerUnitLabel = new Label("Price/unit");

		//add all controls to topGrid
		bottomGrid.add(unitLabel, 0, 1);
		bottomGrid.add(pricePerUnitLabel, 0, 2);
		bottomGrid.add(itemsComboBox, 0, 0, 2, 1);
		bottomGrid.add(unitValueLabel, 1, 1);
		bottomGrid.add(unitPriceValueLabel, 1, 2);

		// set all columns' width 
		for (int i = 0; i < 5; i++)
			bottomGrid.getColumnConstraints().add(new ColumnConstraints(120)); 

		//set up look and feel, fonts, alignment, etc.
		itemsComboBox.setPromptText("Select item");
		unitValueLabel.setTextFill(Color.TEAL);
		unitPriceValueLabel.setTextFill(Color.TEAL);
		unitLabel.setFont(Font.font(15));
		pricePerUnitLabel.setFont(Font.font(15));
		unitValueLabel.setFont(Font.font(15));
		unitPriceValueLabel.setFont(Font.font(15));

	

		quantitySlider.setMinorTickCount(1);
		quantitySlider.setMajorTickUnit(2);
		quantitySlider.setMaxWidth(300);
		quantitySlider.setSnapToTicks(true);
		quantitySlider.setShowTickLabels(true);
		quantitySlider.setShowTickMarks(true);

		Label qtySliderLabel = new Label("Select units");
		Label purchasedUnitsLabel = new Label("Quantity");




		qtySliderLabel.setFont(Font.font(15));
		purchasedUnitsLabel.setFont(Font.font(15));
		purchasedUnitsValueLabel.setFont(Font.font(15));
		purchasedUnitsValueLabel.setTextFill(Color.TEAL);
		


		//setup bottomGrid
		VBox centerVbox = new VBox();
		HBox topButtoncenter = new HBox();
		topButtoncenter.setSpacing(10);
		topButtoncenter.setPadding(new Insets(10,10,10,10));
		BorderPane bp = new BorderPane();

		GridPane buttonGrid = new GridPane();
		GridPane topGrid = new GridPane();
		root.setCenter(centerVbox);
		root.setRight(buttonGrid);
		topGrid.setVgap(10);
		topGrid.setHgap(10);
		buttonGrid.setVgap(10);
		buttonGrid.setHgap(10);
		centerVbox.getChildren().addAll(topButtoncenter,topGrid);




		Label subtotalLabel = new Label("Subtotal:");
		subtotalLabel.setFont(Font.font(12));

		subtotalValueLabel.setFont(Font.font(12));

		Label taxLabel = new Label("Tax:");
		taxLabel.setFont(Font.font(12));

		taxValueLabel.setFont(Font.font(12));

		Label balanceLabel = new Label("Balance Due:");
		balanceLabel.setFont(Font.font(12));

		totalValueLabel.setFont(Font.font(12));

		Label totalLabel = new Label("TOTAL:");
		totalLabel.setFont(Font.font(20));
		totalLabel.setStyle("-fx-font-weight: bold");

		totalValueLabel.setFont(Font.font(20));


		//setup Add button and Total amount


//		addButton.setPrefWidth(150);
//		addButton.setFont(Font.font(15));
//		addButton.setPrefHeight(100);
		

		coffeeButton.setFont(Font.font(20));
		coffeeButton.setPrefWidth(200);
		coffeeButton.setPrefHeight(100);
		coffeeButton.setStyle("-fx-background-color: Orange");

		//		coffee sub categories
		brewedButton.setFont(Font.font(20));
		brewedButton.setPrefWidth(200);
		brewedButton.setPrefHeight(100);
		brewedButton.setWrapText(true);
		brewedButton.setStyle("-fx-background-color: Orange");
		brewedButton.setVisible(false);

		auLaitButton.setFont(Font.font(20));
		auLaitButton.setPrefWidth(200);
		auLaitButton.setPrefHeight(100);
		auLaitButton.setWrapText(true);
		auLaitButton.setStyle("-fx-background-color: Orange");
		auLaitButton.setVisible(false);

		frenchPressButton.setFont(Font.font(20));
		frenchPressButton.setPrefWidth(200);
		frenchPressButton.setPrefHeight(100);
		frenchPressButton.setWrapText(true);
		frenchPressButton.setStyle("-fx-background-color: Orange");
		frenchPressButton.setVisible(false);

		icedCoffeeButton.setFont(Font.font(20));
		icedCoffeeButton.setPrefWidth(200);
		icedCoffeeButton.setPrefHeight(100);
		icedCoffeeButton.setWrapText(true);
		icedCoffeeButton.setStyle("-fx-background-color: Orange");
		icedCoffeeButton.setVisible(false);

		nitroButton.setFont(Font.font(20));
		nitroButton.setPrefWidth(200);
		nitroButton.setPrefHeight(100);
		nitroButton.setWrapText(true);
		nitroButton.setStyle("-fx-background-color: Orange");
		nitroButton.setVisible(false);

		coldBrewButton.setFont(Font.font(20));
		coldBrewButton.setPrefWidth(200);
		coldBrewButton.setPrefHeight(100);
		coldBrewButton.setWrapText(true);
		coldBrewButton.setStyle("-fx-background-color: Orange");
		coldBrewButton.setVisible(false);

		nitroWButton.setFont(Font.font(20));
		nitroWButton.setPrefWidth(200);
		nitroWButton.setPrefHeight(100);
		nitroWButton.setWrapText(true);
		nitroWButton.setStyle("-fx-background-color: Orange");
		nitroWButton.setVisible(false);

		nitroWSweetButton.setFont(Font.font(20));
		nitroWSweetButton.setPrefWidth(200);
		nitroWSweetButton.setPrefHeight(100);
		nitroWSweetButton.setWrapText(true);
		nitroWSweetButton.setStyle("-fx-background-color: Orange");
		nitroWSweetButton.setVisible(false);

		nitroCascaraButton.setFont(Font.font(20));
		nitroCascaraButton.setPrefWidth(200);
		nitroCascaraButton.setPrefHeight(100);
		nitroCascaraButton.setWrapText(true);
		nitroCascaraButton.setStyle("-fx-background-color: Orange");
		nitroCascaraButton.setVisible(false);

		vcoldBrewButton.setFont(Font.font(20));
		vcoldBrewButton.setPrefWidth(200);
		vcoldBrewButton.setPrefHeight(100);
		vcoldBrewButton.setWrapText(true);
		vcoldBrewButton.setStyle("-fx-background-color: Orange");
		vcoldBrewButton.setVisible(false);

		icedCoffeeWButton.setFont(Font.font(20));
		icedCoffeeWButton.setPrefWidth(200);
		icedCoffeeWButton.setPrefHeight(100);
		icedCoffeeWButton.setWrapText(true);
		icedCoffeeWButton.setStyle("-fx-background-color: Orange");
		icedCoffeeWButton.setVisible(false);


		noncoffeeButton.setFont(Font.font(20));
		noncoffeeButton.setWrapText(true);
		noncoffeeButton.setPrefWidth(200);
		noncoffeeButton.setPrefHeight(100);
		noncoffeeButton.setStyle("-fx-background-color: Gold");

		//		non-coffee sub categories
		blackTeaButton.setFont(Font.font(20));
		blackTeaButton.setPrefWidth(200);
		blackTeaButton.setPrefHeight(100);
		blackTeaButton.setWrapText(true);
		blackTeaButton.setStyle("-fx-background-color: Gold");
		blackTeaButton.setVisible(false);

		greenTeaButton.setFont(Font.font(20));
		greenTeaButton.setPrefWidth(200);
		greenTeaButton.setPrefHeight(100);
		greenTeaButton.setWrapText(true);
		greenTeaButton.setStyle("-fx-background-color: Gold");
		greenTeaButton.setVisible(false);

		herbalTeaButton.setFont(Font.font(20));
		herbalTeaButton.setPrefWidth(200);
		herbalTeaButton.setPrefHeight(100);
		herbalTeaButton.setWrapText(true);
		herbalTeaButton.setStyle("-fx-background-color: Gold");
		herbalTeaButton.setVisible(false);

		oolongTeaButton.setFont(Font.font(20));
		oolongTeaButton.setPrefWidth(200);
		oolongTeaButton.setPrefHeight(100);
		oolongTeaButton.setWrapText(true);
		oolongTeaButton.setStyle("-fx-background-color: Gold");
		oolongTeaButton.setVisible(false);

		chaiLatteButton.setFont(Font.font(20));
		chaiLatteButton.setPrefWidth(200);
		chaiLatteButton.setPrefHeight(100);
		chaiLatteButton.setWrapText(true);
		chaiLatteButton.setStyle("-fx-background-color: Gold");
		chaiLatteButton.setVisible(false);

		greenTeaIceButton.setFont(Font.font(20));
		greenTeaIceButton.setPrefWidth(200);
		greenTeaIceButton.setPrefHeight(100);
		greenTeaIceButton.setWrapText(true);
		greenTeaIceButton.setStyle("-fx-background-color: Gold");
		greenTeaIceButton.setVisible(false);

		greenTeaLemonButton.setFont(Font.font(20));
		greenTeaLemonButton.setPrefWidth(200);
		greenTeaLemonButton.setPrefHeight(100);
		greenTeaLemonButton.setWrapText(true);
		greenTeaLemonButton.setStyle("-fx-background-color: Gold");
		greenTeaLemonButton.setVisible(false);

		iceChaiLatteButton.setFont(Font.font(20));
		iceChaiLatteButton.setPrefWidth(200);
		iceChaiLatteButton.setPrefHeight(100);
		iceChaiLatteButton.setWrapText(true);
		iceChaiLatteButton.setStyle("-fx-background-color: Gold");
		iceChaiLatteButton.setVisible(false);

		matchaLatteButton.setFont(Font.font(20));
		matchaLatteButton.setPrefWidth(200);
		matchaLatteButton.setPrefHeight(100);
		matchaLatteButton.setWrapText(true);
		matchaLatteButton.setStyle("-fx-background-color: Gold");
		matchaLatteButton.setVisible(false);

		iceMatchaLatteButton.setFont(Font.font(20));
		iceMatchaLatteButton.setPrefWidth(200);
		iceMatchaLatteButton.setPrefHeight(100);
		iceMatchaLatteButton.setWrapText(true);
		iceMatchaLatteButton.setStyle("-fx-background-color: Gold");
		iceMatchaLatteButton.setVisible(false);

		matchaLemonButton.setFont(Font.font(20));
		matchaLemonButton.setPrefWidth(200);
		matchaLemonButton.setPrefHeight(100);
		matchaLemonButton.setWrapText(true);
		matchaLemonButton.setStyle("-fx-background-color: Gold");
		matchaLemonButton.setVisible(false);

		whiteTeaButton.setFont(Font.font(20));
		whiteTeaButton.setPrefWidth(200);
		whiteTeaButton.setPrefHeight(100);
		whiteTeaButton.setWrapText(true);
		whiteTeaButton.setStyle("-fx-background-color: Gold");
		whiteTeaButton.setVisible(false);

		whiteTeaLemonButton.setFont(Font.font(20));
		whiteTeaLemonButton.setPrefWidth(200);
		whiteTeaLemonButton.setPrefHeight(100);
		whiteTeaLemonButton.setWrapText(true);
		whiteTeaLemonButton.setStyle("-fx-background-color: Gold");
		whiteTeaLemonButton.setVisible(false);

		peachTeaButton.setFont(Font.font(20));
		peachTeaButton.setPrefWidth(200);
		peachTeaButton.setPrefHeight(100);
		peachTeaButton.setWrapText(true);
		peachTeaButton.setStyle("-fx-background-color: Gold");
		peachTeaButton.setVisible(false);

		pineppleTeaButton.setFont(Font.font(20));
		pineppleTeaButton.setPrefWidth(200);
		pineppleTeaButton.setPrefHeight(100);
		pineppleTeaButton.setWrapText(true);
		pineppleTeaButton.setStyle("-fx-background-color: Gold");
		pineppleTeaButton.setVisible(false);

		strawberryTeaButton.setFont(Font.font(20));
		strawberryTeaButton.setPrefWidth(200);
		strawberryTeaButton.setPrefHeight(100);
		strawberryTeaButton.setWrapText(true);
		strawberryTeaButton.setStyle("-fx-background-color: Gold");
		strawberryTeaButton.setVisible(false);

		berryTeaButton.setFont(Font.font(20));
		berryTeaButton.setPrefWidth(200);
		berryTeaButton.setPrefHeight(100);
		berryTeaButton.setWrapText(true);
		berryTeaButton.setStyle("-fx-background-color: Gold");
		berryTeaButton.setVisible(false);

		hotChocalateButton.setFont(Font.font(20));
		hotChocalateButton.setPrefWidth(200);
		hotChocalateButton.setPrefHeight(100);
		hotChocalateButton.setWrapText(true);
		hotChocalateButton.setStyle("-fx-background-color: Gold");
		hotChocalateButton.setVisible(false);

		lemonadeButton.setFont(Font.font(20));
		lemonadeButton.setPrefWidth(200);
		lemonadeButton.setPrefHeight(100);
		lemonadeButton.setWrapText(true);
		lemonadeButton.setStyle("-fx-background-color: Gold");
		lemonadeButton.setVisible(false);

		fruitSmothieButton.setFont(Font.font(20));
		fruitSmothieButton.setPrefWidth(200);
		fruitSmothieButton.setPrefHeight(100);
		fruitSmothieButton.setWrapText(true);
		fruitSmothieButton.setStyle("-fx-background-color: Gold");
		fruitSmothieButton.setVisible(false);

		orangeJuiceButton.setFont(Font.font(20));
		orangeJuiceButton.setPrefWidth(200);
		orangeJuiceButton.setPrefHeight(100);
		orangeJuiceButton.setWrapText(true);
		orangeJuiceButton.setStyle("-fx-background-color: Gold");
		orangeJuiceButton.setVisible(false);



		espressoButton.setFont(Font.font(20));
		espressoButton.setPrefWidth(200);
		espressoButton.setPrefHeight(100);
		espressoButton.setStyle("-fx-background-color: Pink");

		//		espresso sub categories
		espressButton.setFont(Font.font(20));
		espressButton.setPrefWidth(200);
		espressButton.setPrefHeight(100);
		espressButton.setWrapText(true);
		espressButton.setStyle("-fx-background-color: Pink");
		espressButton.setVisible(false);

		macchiatoButton.setFont(Font.font(20));
		macchiatoButton.setPrefWidth(200);
		macchiatoButton.setPrefHeight(100);
		macchiatoButton.setWrapText(true);
		macchiatoButton.setStyle("-fx-background-color: Pink");
		macchiatoButton.setVisible(false);

		conPannaButton.setFont(Font.font(20));
		conPannaButton.setPrefWidth(200);
		conPannaButton.setPrefHeight(100);
		conPannaButton.setWrapText(true);
		conPannaButton.setStyle("-fx-background-color: Pink");
		conPannaButton.setVisible(false);

		cafeLatteButton.setFont(Font.font(20));
		cafeLatteButton.setPrefWidth(200);
		cafeLatteButton.setPrefHeight(100);
		cafeLatteButton.setWrapText(true);
		cafeLatteButton.setStyle("-fx-background-color: Pink");
		cafeLatteButton.setVisible(false);

		classicCapButton.setFont(Font.font(20));
		classicCapButton.setPrefWidth(200);
		classicCapButton.setPrefHeight(100);
		classicCapButton.setWrapText(true);
		classicCapButton.setStyle("-fx-background-color: Pink");
		classicCapButton.setVisible(false);

		cappuccinoButton.setFont(Font.font(20));
		cappuccinoButton.setPrefWidth(200);
		cappuccinoButton.setPrefHeight(100);
		cappuccinoButton.setWrapText(true);
		cappuccinoButton.setStyle("-fx-background-color: Pink");
		cappuccinoButton.setVisible(false);

		mochaButton.setFont(Font.font(20));
		mochaButton.setPrefWidth(200);
		mochaButton.setPrefHeight(100);
		mochaButton.setWrapText(true);
		mochaButton.setStyle("-fx-background-color: Pink");
		mochaButton.setVisible(false);

		caramelButton.setFont(Font.font(20));
		caramelButton.setPrefWidth(200);
		caramelButton.setPrefHeight(100);
		caramelButton.setWrapText(true);
		caramelButton.setStyle("-fx-background-color: Pink");
		caramelButton.setVisible(false);

		vanillaButton.setFont(Font.font(20));
		vanillaButton.setPrefWidth(200);
		vanillaButton.setPrefHeight(100);
		vanillaButton.setWrapText(true);
		vanillaButton.setStyle("-fx-background-color: Pink");
		vanillaButton.setVisible(false);

		mielButton.setFont(Font.font(20));
		mielButton.setPrefWidth(200);
		mielButton.setPrefHeight(100);
		mielButton.setWrapText(true);
		mielButton.setStyle("-fx-background-color: Pink");
		mielButton.setVisible(false);

		americanoButton.setFont(Font.font(20));
		americanoButton.setPrefWidth(200);
		americanoButton.setPrefHeight(100);
		americanoButton.setWrapText(true);
		americanoButton.setStyle("-fx-background-color: Pink");
		americanoButton.setVisible(false);

		caramelMacchiatoButton.setFont(Font.font(20));
		caramelMacchiatoButton.setPrefWidth(200);
		caramelMacchiatoButton.setPrefHeight(100);
		caramelMacchiatoButton.setWrapText(true);
		caramelMacchiatoButton.setStyle("-fx-background-color: Pink");
		caramelMacchiatoButton.setVisible(false);

		cinnamonMacchiatoButton.setFont(Font.font(20));
		cinnamonMacchiatoButton.setPrefWidth(200);
		cinnamonMacchiatoButton.setPrefHeight(100);
		cinnamonMacchiatoButton.setWrapText(true);
		cinnamonMacchiatoButton.setStyle("-fx-background-color: Pink");
		cinnamonMacchiatoButton.setVisible(false);

		skinnyMochaButton.setFont(Font.font(20));
		skinnyMochaButton.setPrefWidth(200);
		skinnyMochaButton.setPrefHeight(100);
		skinnyMochaButton.setWrapText(true);
		skinnyMochaButton.setStyle("-fx-background-color: Pink");
		skinnyMochaButton.setVisible(false);

		blondeButton.setFont(Font.font(20));
		blondeButton.setPrefWidth(200);
		blondeButton.setPrefHeight(100);
		blondeButton.setWrapText(true);
		blondeButton.setStyle("-fx-background-color: Pink");
		blondeButton.setVisible(false);

		blondeCaramelButton.setFont(Font.font(20));
		blondeCaramelButton.setPrefWidth(200);
		blondeCaramelButton.setPrefHeight(100);
		blondeCaramelButton.setWrapText(true);
		blondeCaramelButton.setStyle("-fx-background-color: Pink");
		blondeCaramelButton.setVisible(false);

		blondeCinnamonButton.setFont(Font.font(20));
		blondeCinnamonButton.setPrefWidth(200);
		blondeCinnamonButton.setPrefHeight(100);
		blondeCinnamonButton.setWrapText(true);
		blondeCinnamonButton.setStyle("-fx-background-color: Pink");
		blondeCinnamonButton.setVisible(false);

		blondeLatteButton.setFont(Font.font(20));
		blondeLatteButton.setPrefWidth(200);
		blondeLatteButton.setPrefHeight(100);
		blondeLatteButton.setWrapText(true);
		blondeLatteButton.setStyle("-fx-background-color: Pink");
		blondeLatteButton.setVisible(false);

		blondeAmericanoButton.setFont(Font.font(20));
		blondeAmericanoButton.setPrefWidth(200);
		blondeAmericanoButton.setPrefHeight(100);
		blondeAmericanoButton.setWrapText(true);
		blondeAmericanoButton.setStyle("-fx-background-color: Pink");
		blondeAmericanoButton.setVisible(false);

		blondeVanillaButton.setFont(Font.font(20));
		blondeVanillaButton.setPrefWidth(200);
		blondeVanillaButton.setPrefHeight(100);
		blondeVanillaButton.setWrapText(true);
		blondeVanillaButton.setStyle("-fx-background-color: Pink");
		blondeVanillaButton.setVisible(false);

		flatWhiteButton.setFont(Font.font(20));
		flatWhiteButton.setPrefWidth(200);
		flatWhiteButton.setPrefHeight(100);
		flatWhiteButton.setWrapText(true);
		flatWhiteButton.setStyle("-fx-background-color: Pink");
		flatWhiteButton.setVisible(false);

		whiteChocalateButton.setFont(Font.font(20));
		whiteChocalateButton.setPrefWidth(200);
		whiteChocalateButton.setPrefHeight(100);
		whiteChocalateButton.setWrapText(true);
		whiteChocalateButton.setStyle("-fx-background-color: Pink");
		whiteChocalateButton.setVisible(false);

		pastriesButton.setFont(Font.font(20));
		pastriesButton.setPrefWidth(200);
		pastriesButton.setPrefHeight(100);
		pastriesButton.setStyle("-fx-background-color: Plum");

		//		pastries sub categories
		blueMuffinButton.setFont(Font.font(20));
		blueMuffinButton.setPrefWidth(200);
		blueMuffinButton.setPrefHeight(100);
		blueMuffinButton.setWrapText(true);
		blueMuffinButton.setStyle("-fx-background-color: Plum");
		blueMuffinButton.setVisible(false);

		croissantButterButton.setFont(Font.font(20));
		croissantButterButton.setPrefWidth(200);
		croissantButterButton.setPrefHeight(100);
		croissantButterButton.setWrapText(true);
		croissantButterButton.setStyle("-fx-background-color: Plum");
		croissantButterButton.setVisible(false);

		bagelButton.setFont(Font.font(20));
		bagelButton.setPrefWidth(200);
		bagelButton.setPrefHeight(100);
		bagelButton.setWrapText(true);
		bagelButton.setStyle("-fx-background-color: Plum");
		bagelButton.setVisible(false);

		cinnamonButton.setFont(Font.font(20));
		cinnamonButton.setPrefWidth(200);
		cinnamonButton.setPrefHeight(100);
		cinnamonButton.setWrapText(true);
		cinnamonButton.setStyle("-fx-background-color: Plum");
		cinnamonButton.setVisible(false);

		tartButton.setFont(Font.font(20));
		tartButton.setPrefWidth(200);
		tartButton.setPrefHeight(100);
		tartButton.setWrapText(true);
		tartButton.setStyle("-fx-background-color: Plum");
		tartButton.setVisible(false);

		eclairButton.setFont(Font.font(20));
		eclairButton.setPrefWidth(200);
		eclairButton.setPrefHeight(100);
		eclairButton.setWrapText(true);
		eclairButton.setStyle("-fx-background-color: Plum");
		eclairButton.setVisible(false);

		puffButton.setFont(Font.font(20));
		puffButton.setPrefWidth(200);
		puffButton.setPrefHeight(100);
		puffButton.setWrapText(true);
		puffButton.setStyle("-fx-background-color: Plum");
		puffButton.setVisible(false);

		bagelVeganButton.setFont(Font.font(20));
		bagelVeganButton.setPrefWidth(200);
		bagelVeganButton.setPrefHeight(100);
		bagelVeganButton.setWrapText(true);
		bagelVeganButton.setStyle("-fx-background-color: Plum");
		bagelVeganButton.setVisible(false);

		bagelCinRasianButton.setFont(Font.font(20));
		bagelCinRasianButton.setPrefWidth(200);
		bagelCinRasianButton.setPrefHeight(100);
		bagelCinRasianButton.setWrapText(true);
		bagelCinRasianButton.setStyle("-fx-background-color: Plum");
		bagelCinRasianButton.setVisible(false);

		almondCroissantButton.setFont(Font.font(20));
		almondCroissantButton.setPrefWidth(200);
		almondCroissantButton.setPrefHeight(100);
		almondCroissantButton.setWrapText(true);
		almondCroissantButton.setStyle("-fx-background-color: Plum");
		almondCroissantButton.setVisible(false);

		croissantChocoButton.setFont(Font.font(20));
		croissantChocoButton.setPrefWidth(200);
		croissantChocoButton.setPrefHeight(100);
		croissantChocoButton.setWrapText(true);
		croissantChocoButton.setStyle("-fx-background-color: Plum");
		croissantChocoButton.setVisible(false);

		bithdayPopButton.setFont(Font.font(20));
		bithdayPopButton.setPrefWidth(200);
		bithdayPopButton.setPrefHeight(100);
		bithdayPopButton.setWrapText(true);
		bithdayPopButton.setStyle("-fx-background-color: Plum");
		bithdayPopButton.setVisible(false);

		lemonPopButton.setFont(Font.font(20));
		lemonPopButton.setPrefWidth(200);
		lemonPopButton.setPrefHeight(100);
		lemonPopButton.setWrapText(true);
		lemonPopButton.setStyle("-fx-background-color: Plum");
		lemonPopButton.setVisible(false);

		chocoPopButton.setFont(Font.font(20));
		chocoPopButton.setPrefWidth(200);
		chocoPopButton.setPrefHeight(100);
		chocoPopButton.setWrapText(true);
		chocoPopButton.setStyle("-fx-background-color: Plum");
		chocoPopButton.setVisible(false);

		bananaButton.setFont(Font.font(20));
		bananaButton.setPrefWidth(200);
		bananaButton.setPrefHeight(100);
		bananaButton.setWrapText(true);
		bananaButton.setStyle("-fx-background-color: Plum");
		bananaButton.setVisible(false);

		sconeVanillaButton.setFont(Font.font(20));
		sconeVanillaButton.setPrefWidth(200);
		sconeVanillaButton.setPrefHeight(100);
		sconeVanillaButton.setWrapText(true);
		sconeVanillaButton.setStyle("-fx-background-color: Plum");
		sconeVanillaButton.setVisible(false);

		sconeStrawberryButton.setFont(Font.font(20));
		sconeStrawberryButton.setPrefWidth(200);
		sconeStrawberryButton.setPrefHeight(100);
		sconeStrawberryButton.setWrapText(true);
		sconeStrawberryButton.setStyle("-fx-background-color: Plum");
		sconeStrawberryButton.setVisible(false);

		lemonCakeButton.setFont(Font.font(20));
		lemonCakeButton.setPrefWidth(200);
		lemonCakeButton.setPrefHeight(100);
		lemonCakeButton.setWrapText(true);
		lemonCakeButton.setStyle("-fx-background-color: Plum");
		lemonCakeButton.setVisible(false);

		brownieButton.setFont(Font.font(20));
		brownieButton.setPrefWidth(200);
		brownieButton.setPrefHeight(100);
		brownieButton.setWrapText(true);
		brownieButton.setStyle("-fx-background-color: Plum");
		brownieButton.setVisible(false);

		sugarCookieButton.setFont(Font.font(20));
		sugarCookieButton.setPrefWidth(200);
		sugarCookieButton.setPrefHeight(100);
		sugarCookieButton.setWrapText(true);
		sugarCookieButton.setStyle("-fx-background-color: Plum");
		sugarCookieButton.setVisible(false);

		coffeeCakeButton.setFont(Font.font(20));
		coffeeCakeButton.setPrefWidth(200);
		coffeeCakeButton.setPrefHeight(100);
		coffeeCakeButton.setWrapText(true);
		coffeeCakeButton.setStyle("-fx-background-color: Plum");
		coffeeCakeButton.setVisible(false);

		donutButton.setFont(Font.font(20));
		donutButton.setPrefWidth(200);
		donutButton.setPrefHeight(100);
		donutButton.setWrapText(true);
		donutButton.setStyle("-fx-background-color: Plum");
		donutButton.setVisible(false);

		sconeBlueButton.setFont(Font.font(20));
		sconeBlueButton.setPrefWidth(200);
		sconeBlueButton.setPrefHeight(100);
		sconeBlueButton.setWrapText(true);
		sconeBlueButton.setStyle("-fx-background-color: Plum");
		sconeBlueButton.setVisible(false);

		payButton.setPrefWidth(150);
		payButton.setFont(Font.font(15));
		payButton.setPrefHeight(100);
		topButtoncenter.getChildren().add(payButton);
		payButton.setStyle("-fx-background-color: SkyBlue");

		cashButton.setPrefWidth(150);
		cashButton.setFont(Font.font(15));
		cashButton.setPrefHeight(200);

		cardButton.setPrefWidth(150);
		cardButton.setFont(Font.font(15));
		cardButton.setPrefHeight(200);

		userButton.setPrefWidth(150);
		userButton.setFont(Font.font(15));
		userButton.setPrefHeight(100);
		topButtoncenter.getChildren().add(userButton);
		userButton.setStyle("-fx-background-color: SkyBlue");


		loginButton.setPrefWidth(150);
		loginButton.setFont(Font.font(15));
		loginButton.setPrefHeight(200);

		logoutButton.setPrefWidth(150);
		logoutButton.setFont(Font.font(15));
		logoutButton.setPrefHeight(200);

		discountButton.setPrefWidth(150);
		discountButton.setFont(Font.font(15));
		discountButton.setPrefHeight(100);
		topButtoncenter.getChildren().add(discountButton);
		discountButton.setStyle("-fx-background-color: SkyBlue");


		employeeButton.setPrefWidth(150);
		employeeButton.setFont(Font.font(15));
		employeeButton.setPrefHeight(100);

		studentButton.setPrefWidth(150);
		studentButton.setFont(Font.font(15));
		studentButton.setPrefHeight(100);

		happyBDayButton.setPrefWidth(150);
		happyBDayButton.setFont(Font.font(15));
		happyBDayButton.setPrefHeight(100);

		cancelButton.setPrefWidth(150);
		cancelButton.setFont(Font.font(15));
		cancelButton.setPrefHeight(40);

		clearButton.setPrefWidth(150);
		clearButton.setFont(Font.font(15));
		clearButton.setPrefHeight(100);
		topButtoncenter.getChildren().addAll(clearButton);
		clearButton.setStyle("-fx-background-color: SkyBlue");




		removeButton.setFont(Font.font(15));
		removeButton.setPrefWidth(150);
		removeButton.setPrefHeight(100);
		topButtoncenter.getChildren().add(removeButton);
		removeButton.setStyle("-fx-background-color: SkyBlue");


		//Calculator
		b0.setPrefWidth(50);
		b0.setFont(Font.font(15));
		b0.setPrefHeight(50);

		b1.setPrefWidth(50);
		b1.setFont(Font.font(15));
		b1.setPrefHeight(50);

		b2.setPrefWidth(50);
		b2.setFont(Font.font(15));
		b2.setPrefHeight(50);

		b3.setPrefWidth(50);
		b3.setFont(Font.font(15));
		b3.setPrefHeight(50);

		b4.setPrefWidth(50);
		b4.setFont(Font.font(15));
		b4.setPrefHeight(50);

		b5.setPrefWidth(50);
		b5.setFont(Font.font(15));
		b5.setPrefHeight(50);

		b6.setPrefWidth(50);
		b6.setFont(Font.font(15));
		b6.setPrefHeight(50);

		b7.setPrefWidth(50);
		b7.setFont(Font.font(15));
		b7.setPrefHeight(50);

		b8.setPrefWidth(50);
		b8.setFont(Font.font(15));
		b8.setPrefHeight(50);

		b9.setPrefWidth(50);
		b9.setFont(Font.font(15));
		b9.setPrefHeight(50);

		bDot.setPrefWidth(50);
		bDot.setFont(Font.font(15));
		bDot.setPrefHeight(50);

		call.setPrefWidth(100);
		call.setFont(Font.font(15));
		call.setPrefHeight(20);

		thank.setFont(Font.font(25));
		thank.setTextFill(Color.GREEN);
		change.setFont(Font.font(25));
		change.setTextFill(Color.GREEN);

		percentage.setFont(Font.font(15));
		percentage.setTextFill(Color.GREEN);


		totalLabel.setFont(Font.font(15));
		totalValueLabel.setFont(Font.font(15));

		//create table view
		TableColumn<ItemInCart, String> nameColumn = new TableColumn<>("Item name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<ItemInCart, String>("name"));

		TableColumn<ItemInCart, Double> qtyColumn = new TableColumn<>("Purchased units");
		qtyColumn.setCellValueFactory(new PropertyValueFactory<ItemInCart, Double>("quantity"));


		TableColumn<ItemInCart, String> sizeColumn = new TableColumn<>("Size of Cup");
		sizeColumn.setCellValueFactory(new PropertyValueFactory<ItemInCart, String>("size"));

		TableColumn<ItemInCart, String> noteColumn = new TableColumn<>("Notes");
		noteColumn.setCellValueFactory(new PropertyValueFactory<ItemInCart, String>("note"));



		itemsTableView.getColumns().setAll(sizeColumn,nameColumn, qtyColumn, rateColumn, noteColumn);

		itemsTableView.setPrefWidth(850);
		itemsTableView.setPrefHeight(600);
		itemsTableView.getColumns().get(0).setPrefWidth(50);
		itemsTableView.getColumns().get(1).setPrefWidth(150);
		itemsTableView.getColumns().get(2).setPrefWidth(150);
		itemsTableView.getColumns().get(3).setPrefWidth(150);
		itemsTableView.getColumns().get(3).setPrefWidth(150);


		//itemsTableView.resizeColumn(sizeColumn,10);


		//	bottomGrid.add(addButton, 0, 0);
	//	bottomGrid.add(removeButton, 1, 0);
		//bottomGrid.add(itemsTableView, 0, 1, 2, 1);
		bottomGrid.add(totalLabel, 0, 2);
		bottomGrid.add(totalValueLabel, 1, 2);
		
		//topGrid.add(addButton, 0, 0);

		buttonGrid.add(coffeeButton, 4, 0);
		buttonGrid.add(brewedButton, 4, 1);
		buttonGrid.add(coldBrewButton, 5, 1);
		buttonGrid.add(vcoldBrewButton, 6, 1);
		buttonGrid.add(auLaitButton, 7, 1);
		buttonGrid.add(frenchPressButton, 4, 2);
		buttonGrid.add(icedCoffeeButton, 5, 2);
		buttonGrid.add(icedCoffeeWButton, 6, 2);
		buttonGrid.add(nitroButton, 7, 2);
		buttonGrid.add(nitroWButton, 4, 3);
		buttonGrid.add(nitroCascaraButton, 5, 3);
		buttonGrid.add(nitroWSweetButton, 6, 3);

		buttonGrid.add(noncoffeeButton, 5, 0);
		buttonGrid.add(blackTeaButton, 4, 1);
		buttonGrid.add(greenTeaButton, 5, 1);
		buttonGrid.add(greenTeaIceButton, 6, 1);
		buttonGrid.add(greenTeaLemonButton, 7, 1);
		buttonGrid.add(herbalTeaButton, 4, 2);
		buttonGrid.add(oolongTeaButton, 5, 2);
		buttonGrid.add(chaiLatteButton, 6, 2);
		buttonGrid.add(iceChaiLatteButton, 7, 2);
		buttonGrid.add(matchaLatteButton, 4, 3);
		buttonGrid.add(iceMatchaLatteButton, 5, 3);
		buttonGrid.add(matchaLemonButton, 6, 3);
		buttonGrid.add(whiteTeaButton, 7, 3);
		buttonGrid.add(whiteTeaLemonButton, 4, 4);
		buttonGrid.add(peachTeaButton, 5, 4);
		buttonGrid.add(pineppleTeaButton, 6, 4);
		buttonGrid.add(strawberryTeaButton, 7, 4);
		buttonGrid.add(berryTeaButton, 4, 5);
		buttonGrid.add(hotChocalateButton, 5, 5);
		buttonGrid.add(lemonadeButton, 6, 5);
		buttonGrid.add(fruitSmothieButton, 7, 5);
		buttonGrid.add(orangeJuiceButton, 4, 6);

		buttonGrid.add(espressoButton, 6, 0);
		buttonGrid.add(espressButton, 4, 1);
		buttonGrid.add(macchiatoButton, 5, 1);
		buttonGrid.add(caramelMacchiatoButton, 6, 1);
		buttonGrid.add(cinnamonMacchiatoButton, 7, 1);
		buttonGrid.add(conPannaButton, 4, 2);
		buttonGrid.add(cafeLatteButton, 5, 2);
		buttonGrid.add(classicCapButton, 6, 2);
		buttonGrid.add(cappuccinoButton, 7, 2);
		buttonGrid.add(mochaButton, 4, 3);
		buttonGrid.add(caramelButton, 5, 3);
		buttonGrid.add(vanillaButton, 6, 3);
		buttonGrid.add(mielButton, 7, 3);
		buttonGrid.add(americanoButton, 4, 4);
		buttonGrid.add(skinnyMochaButton, 5, 4);
		buttonGrid.add(blondeButton, 6, 4);
		buttonGrid.add(blondeCaramelButton, 7, 4);
		buttonGrid.add(blondeCinnamonButton, 4, 5);
		buttonGrid.add(blondeLatteButton, 5, 5);
		buttonGrid.add(blondeAmericanoButton, 6, 5);
		buttonGrid.add(blondeVanillaButton, 7, 5);
		buttonGrid.add(flatWhiteButton, 4, 6);
		buttonGrid.add(whiteChocalateButton, 5, 6);

		buttonGrid.add(pastriesButton, 7, 0);
		buttonGrid.add(blueMuffinButton, 4, 1);
		buttonGrid.add(croissantButterButton, 5, 1);
		buttonGrid.add(almondCroissantButton, 6, 1);
		buttonGrid.add(croissantChocoButton, 7, 1);
		buttonGrid.add(bagelButton, 4, 2);
		buttonGrid.add(bagelVeganButton, 5, 2);
		buttonGrid.add(bagelCinRasianButton, 6, 2);
		buttonGrid.add(cinnamonButton, 7, 2);
		buttonGrid.add(tartButton, 4, 3);
		buttonGrid.add(eclairButton, 5, 3);
		buttonGrid.add(puffButton, 6, 3);
		buttonGrid.add(bithdayPopButton, 7, 3);
		buttonGrid.add(lemonPopButton, 4, 4);
		buttonGrid.add(chocoPopButton, 5, 4);
		buttonGrid.add(bananaButton, 6, 4);
		buttonGrid.add(sconeVanillaButton, 7, 4);
		buttonGrid.add(sconeStrawberryButton, 4, 5);
		buttonGrid.add(sconeBlueButton, 5, 5);
		buttonGrid.add(lemonCakeButton, 6, 5);
		buttonGrid.add(brownieButton, 7, 5);
		buttonGrid.add(sugarCookieButton, 4, 6);
		buttonGrid.add(coffeeCakeButton, 5, 6);
		buttonGrid.add(donutButton, 6, 6);


		topGrid.add(qtySliderLabel, 1, 8);
		topGrid.add(quantitySlider, 1, 7, 2, 1);
		topGrid.add(purchasedUnitsLabel, 2, 7);
		topGrid.add(purchasedUnitsValueLabel, 2, 8);

		topGrid.add(itemsTableView, 0, 1, 2, 1);
//		topGrid.add(totalLabel, 0, 2);
//		topGrid.add(totalValueLabel, 1, 2);
		//topGrid.add(taxLabel,0,2);
		topGrid.add(subtotalLabel, 0, 2);
		topGrid.add(taxLabel, 0, 3);
		topGrid.add(balanceLabel, 0, 4);
		topGrid.add(totalLabel, 0, 5);
		topGrid.add(subtotalValueLabel, 1, 2);
		topGrid.add(taxValueLabel, 1, 3);
		topGrid.add(balanceValueLabel, 1, 4);
		topGrid.add(totalValueLabel, 1, 5);


//		buttonGrid.setGridLinesVisible(true);
//		topGrid.setGridLinesVisible(true);
//		bottomGrid.setGridLinesVisible(true);

		buttonGrid.setPrefSize(700,700);
		topGrid.setPrefSize(850, 800);
		bottomGrid.setPrefSize(700, 300);

		root.setPrefSize(700, 800);
		BorderPane.setMargin(topGrid, new Insets(10,10,10,10));
		BorderPane.setMargin(bottomGrid, new Insets(10,10,10,10));
		
		return root;
	}

	@SuppressWarnings("unchecked")
	BorderPane secondaryLayout() {
		//popup screen main pane
		BorderPane root2 = new BorderPane();

		//vb for buttons
		VBox vbButton = new VBox();
		//vbox for radio checkbuttons
		VBox vbRadio = new VBox();


		vbRadio.setPadding(new Insets(20));
		vbRadio.setSpacing(10);

		vbCheckButtons.setPadding(new Insets(20));
		vbCheckButtons.setSpacing(10);

		vbButton.setPadding(new Insets(20));
		vbButton.setSpacing(10);

		root2.setCenter(vbRadio);
		root2.setLeft(vbCheckButtons);
		root2.setRight(vbButton);
		


		vbButton.getChildren().addAll(addButton,cancelButton);
		vbCheckButtons.getChildren().addAll(cbAlmondMilk,cbShotFatFreeMilk,cbEspressoShot,cbWHip,cbBoba,cbChocolate,cbIce,cbLightIce,request);


		//all secondary buttons go into an array for use outside of this class
		list.add(cbShotFatFreeMilk);
		list.add(cbAlmondMilk);
		list.add(cbEspressoShot);
		list.add(cbWHip);
		list.add(cbBoba);
		list.add(cbChocolate);
		list.add(cbIce);
		list.add(cbLightIce);
		list.add(request);


		RadioButton rb1 = new RadioButton("Large");
		rb1.setToggleGroup(toggleGroup);
		rb1.setSelected(true);

		RadioButton rb2 = new RadioButton("Medium");
		rb2.setToggleGroup(toggleGroup);

		RadioButton rb3 = new RadioButton("Small");
		rb3.setToggleGroup(toggleGroup);

		vbRadio.getChildren().addAll(rb1,rb2,rb3);


		return root2;

	}
	BorderPane payLayout() {
		BorderPane root = new BorderPane();
		GridPane topGrid = new GridPane();
		root.setBottom(topGrid);

		/**setup topGrid */
		topGrid.setVgap(1);
		topGrid.setHgap(1);

		topGrid.add(cardButton, 5, 0);
		topGrid.add(cashButton, 10, 0);
		topGrid.setPrefSize(300, 150);

		return root;
	}

	BorderPane discountLayout() {
		BorderPane root = new BorderPane();
		GridPane topGrid = new GridPane();
		root.setBottom(topGrid);

		/**setup topGrid */
		topGrid.setVgap(1);
		topGrid.setHgap(1);

		topGrid.add(employeeButton, 20, 0);
		topGrid.add(studentButton, 25, 0);
		topGrid.add(happyBDayButton, 30, 0);
		topGrid.add(cancelButton, 25, 10);
		topGrid.setPrefSize(300, 150);

		return root;
	}

	BorderPane userLayout() {
		BorderPane root = new BorderPane();
		GridPane topGrid = new GridPane();
		root.setBottom(topGrid);

		/**setup topGrid */
		topGrid.setVgap(1);
		topGrid.setHgap(1);

		topGrid.add(loginButton, 5, 0);
		topGrid.add(logoutButton, 10, 0);
		topGrid.setPrefSize(300, 150);

		return root;
	}

	BorderPane cashLayout() {
		BorderPane root = new BorderPane();
		GridPane numPad = new GridPane();

		numPad.add(b1, 0, 0);
		numPad.add(b2, 1, 0);
		numPad.add(b3, 2, 0);
		numPad.add(b4, 0, 1);
		numPad.add(b5, 1, 1);
		numPad.add(b6, 2, 1);
		numPad.add(b7, 0, 2);
		numPad.add(b8, 1, 2);
		numPad.add(b9, 2, 2);
		numPad.add(b0, 1, 3);
		numPad.add(bDot, 0, 3);

		numPad.add(call, 0, 4);

		GridPane.setColumnSpan(call, 3);

		root.setTop(cal);
		root.setCenter(numPad);

		return root;
	}

	BorderPane finalLayout() {
		BorderPane root = new BorderPane();

		root.setTop(thank);
		root.setBottom(change);

		return root;
	}

}

