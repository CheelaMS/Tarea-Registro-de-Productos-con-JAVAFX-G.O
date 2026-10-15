package cl.duoc.tabla;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ProductoController {

    private final ObservableList<Producto> productos= FXCollections.observableArrayList();

    public VBox crearVista(){
        TableView<Producto> tabla = new TableView<>();

        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");

        colNombre.setCellValueFactory(dato ->
                new SimpleStringProperty(dato.getValue().nombre()));


        TableColumn<Producto, String> colCategoria = new TableColumn<>("Categoria");

        colCategoria.setCellValueFactory(dato ->
                new SimpleStringProperty(dato.getValue().categoria()));

        TableColumn<Producto, String> colPrecio = new TableColumn<>("Precio");

        colPrecio.setCellValueFactory(dato ->
                new SimpleStringProperty("$ "+ dato.getValue().precio()));

        tabla.getColumns().addAll(colNombre,colCategoria,colPrecio);

        tabla.setItems(productos);

        productos.add(new Producto("Teclado","Periferico",15000));
        productos.add(new Producto("Mouse","Periferico",8000));
        productos.add(new Producto("Monitor","Pantallas",95000));



        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre:");

        TextField txtCategoria = new TextField();
        txtCategoria.setPromptText("Categoria:");

        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio:");

        Button btnAgregar = new Button("Agregar Producto");

        // Acción del botón.
        btnAgregar.setOnAction(evento -> {
            String nombre = txtNombre.getText();
            String categoria = txtCategoria.getText();
            double precio = Double.parseDouble(txtPrecio.getText());

            // Agregamos el Producto a la lista observable.
            productos.add(new Producto(nombre, categoria, precio));

            // Limpiamos los campos.
            txtNombre.clear();
            txtCategoria.clear();
            txtPrecio.clear();
        });

        // VBox ordena los elementos de arriba hacia abajo.
        return new VBox(10, tabla, txtNombre, txtCategoria, txtPrecio, btnAgregar);


    }

    }



