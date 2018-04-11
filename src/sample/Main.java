package sample;

import com.cenfotec.map.Utils.GraphPaths.Dijkstra;
import com.cenfotec.map.core.structures.Graph;
import com.cenfotec.map.core.structures.nodes.Vertex;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("loadingPage.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
//        Vertex<String> A=new Vertex<>("Letra A","A");
//        Vertex<String>B=new Vertex<>("Letra B","B");
//        Vertex<String>C=new Vertex<>("Letra C","C");
//        Vertex<String>D=new Vertex<>("Letra D","D");
//
//        A.addEdge(B,5);
//        A.addEdge(C,10);
//        B.addEdge(A,5);
//        B.addEdge(D,11);
//        B.addEdge(C,4);
//        C.addEdge(A,10);
//        C.addEdge(D,5);
//        C.addEdge(B,4);
//        D.addEdge(B,11);
//        D.addEdge(C,5);
//        ArrayList<Vertex> vertexs=new ArrayList<>();
//        vertexs.add(A);
//        vertexs.add(B);
//        vertexs.add(C);
//        vertexs.add(D);
//        Graph<String> g= new Graph<>(vertexs);
//        System.out.println("keys"+g.vertexKeys());
//        Dijkstra dijkstra=new Dijkstra(g,"Winterfell");
//        for (Vertex vertex:dijkstra.getPathTo("Kingslanding")){
//            System.out.println(vertex.getLabel());
//        }
//
//        System.out.println(dijkstra.getDistanceTo("D"));
    }
}
