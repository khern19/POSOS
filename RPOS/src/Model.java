import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	
	ObservableList<Item> itemsObservableList = FXCollections.observableArrayList();
	ObservableList<ItemInCart> cartObservableList = FXCollections.observableArrayList();
	
	void loadData() {
		try (BufferedReader br = new BufferedReader(new FileReader("D:\\ufoet\\Documents\\WorkSpace\\CS3337\\src\\FinalPOS\\ItemsMaster.csv"))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				Item item = new Item(values[0], values[1], Double.parseDouble(values[2]), Double.parseDouble(values[3]),values[4],values[5]);
				itemsObservableList.add(item);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
