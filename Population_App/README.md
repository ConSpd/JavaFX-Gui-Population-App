// Path to .jar Files: MAEProject/src/KostasPackage.
// The command that reads the file in excelReader.java (Line 18) will need modification.
   

### Country.java:
The implementation of the class that will be used to store the countries. It contains all the attributes needed along with a HashMap called DataBase that will be used later, the HashMap stores Years & last Population count. Also the Population attibute counts the last Population count. Apart from attributes all the methods it contains are setters & getters which will be needed later.

### Main.java:
The method that implements the main window and calls the graph window, Toast message and the method that reads the Excel File. First we create the columns and set their names and which attribute they will use from Country to set their values. After initializing them we call the Process() method of excelReader which is explained below what its function is(*). We create a TableView object, we set its values through the ObservableList country object. We create 2 buttons one for Exit and one for Chart and set them inside a Layout HBox so that they are placed horizontally in the Scene. Then we set the TableView in a VBox so that it goes vertically into the Scene and set both Layouts inside a BorderPane. If the Chart button is clicked the Graph.window(\*\*) is activated. If we click on the table we check with a setOnMouseClicked if we clicked twice and get the Index (position) of the table we clicked and call the message method of Toast(\*\*\*) with parameters ObservableList country, index and primaryStage.

### (*)excelReader.java:
The method returns an ObservableList that has a Country class for each element. First we read the file to initialize an object of the XSSFWorkbook class that takes the file as an argument, and then the workbook file will be used to create an XSSFSheet object to get the 
page we are interested in, in this case it is the first (0). We initialize an object of the ObservableList class with Country elements that we will name statistics and set year as the first known year (1950). We start from the known line (44) to store the countries. We save the row and check if the 6th column of this row says Country/Area to avoid the
subordinates. If it is Country/Area then we create a Country object and with the setter methods we store the Attributes (Country Name, Code, Index etc.). Then in a for loop we start from the known 8th column and store in the HashMap of the object the year (keeping a variable year which after the completion of the
loop is completed, it reverts to the value 1950 for the next country) and the population. We also store the last year and the population of the last count. We then add the object to the ObservableList statistics to return it at the end.

### (\*\*)Graph.java:
To set the final value of the X-axis we get the final measurement year from the country object which we get as an argument from main. We create second stage, set name, ComboBox for the bar and in each element we put the country name. xAxis from 1950 to the final year. We create a close button and if the user clicks on an element of the ComboBox we get the name of the 
country with getValue() and we create XYChart object to set the statistics of the country. We check the whole country table to find the country selected and then through the HashMap which is the DataBase we add year & population.
We put the buttons in Layout HBox and the Graph directly in BorderPane along with the HBox. We set the primaryStage as the parent (so that it doesn't close until the primaryStage is closed). we are the specific window), with initOwner and initModality.

### (\*\*\*)Toast.java
With index we find the position of the table we are looking for, and store the name, index and population in variables. We define these three inside a Label.
We create a square, and with setArcHeight & setArcWidth we make it have convex corners, and finally we set the Label and the Square to disappear. With KeyValue we set the initial and final value of both for opacity, with KeyFrame we set how long we want the transition to occur and with Time line we set them in motion. All of this is implemented inside a Popup that we set inside the primaryStage.
