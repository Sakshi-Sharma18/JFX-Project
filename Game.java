import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.control.TextField;
import java.io.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.scene.input.MouseEvent;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.scene.control.Tooltip;

public class Game extends Application 
{
	public void start(Stage stage1) throws Exception
	{
		//Stage 1
		
		
		VBox root = new VBox(50);

		//GAME LABEL

		Label G_Name = new Label("GAME");
		G_Name.setFont(new Font("Broadway", 100));
		G_Name.setAlignment(Pos.CENTER);
		G_Name.setMaxSize(1000,1000);
		


		//TEXT FIELDS AND PASSWORD FIELDS

		VBox root1 = new VBox();
		
		Label l1 = new Label("Player Details");
		l1.setFont(new Font("Broadway", 38));
		l1.setAlignment(Pos.CENTER);
		l1.setMaxSize(1000,1000);
		TextField tf = new TextField();
		tf.setMinWidth(20);
		tf.setMaxWidth(300);

		Tooltip t = new Tooltip("Username");
		Tooltip.install(tf, t);
		PasswordField pf = new PasswordField();
		pf.setMinWidth(20);
		pf.setMaxWidth(300);
		pf.setPromptText("Password");
		
		

		//BUTTONS

		HBox root2 = new HBox(60);
		Button start = new Button("Start Game");
		Button help = new Button("How to play");
		root2.getChildren().addAll(start,help);
		root2.setAlignment(Pos.CENTER);
		start.setDisable(true);

		Button sub = new Button("Submit");
		sub.setOnAction(new EventHandler<ActionEvent>()
			{
				public void handle(ActionEvent ae)
				{
					String un=tf.getText();
					String p=pf.getText();
					if(un.equals("")==false && p.equals("")==false)
						start.setDisable(false);
				}
			});
		
					
	
		start.setDefaultButton(true);


		root1.getChildren().addAll(l1,tf,pf,sub);
		root1.setAlignment(Pos.CENTER);


		//HOW TO PLAY
		help.setOnAction(new EventHandler<ActionEvent>()
			{
				public void handle(ActionEvent ae)
				{
					Stage next = new Stage();
					VBox root3 = new VBox(10);
					Label l11 = new Label("1. Use arrow keys to move");
					Label l12 = new Label("2. Reach destination on screen");
					Label l13 = new Label("3. Avoid touching the obstacles");
				
					l11.setFont(new Font("Consolas", 26));
					l12.setFont(new Font("Consolas", 26));
					l13.setFont(new Font("Consolas", 26));
					
					Button OK = new Button("Got it!");

					OK.setOnAction(new EventHandler<ActionEvent>()
					{
						public void handle(ActionEvent ae)
						{
							next.close();
						}
					});

					root3.getChildren().addAll(l11,l12,l13,OK);
					root3.setAlignment(Pos.CENTER);
					Scene s2 = new Scene(root3,500,500,Color.rgb(100,100,150,0.5));
					
					next.setTitle("How to play");
					next.setScene(s2);
					next.setX(stage1.getX()+100);
					next.setY(stage1.getY()+200);
					next.initModality(Modality.WINDOW_MODAL); 
					next.initOwner(stage1);
					next.show();
				}
			});
		
		//START GAME
		start.setOnAction(new EventHandler<ActionEvent>()
			{
				public void handle(ActionEvent ae)
				{
					Stage next = new Stage();
					Circle source = new Circle(50,450,50);
					VBox root4 = new VBox();
					
					//MENU BAR

					MenuBar mb = new MenuBar();
					Menu m1 = new Menu("Game settings");
					Menu m2 = new Menu("Stuck?");
		
					MenuItem mi1 = new MenuItem("Controls");
					MenuItem mi2 = new MenuItem("Rules");
					
					m1.getItems().add(mi1);
					m1.getItems().add(mi2);

					MenuItem mi3 = new MenuItem("Refresh");
					MenuItem mi4 = new MenuItem("Quit");
					
					m2.getItems().add(mi3);
					m2.getItems().add(mi4);


					mb.getMenus().add(m1);
					mb.getMenus().add(m2);


					mi3.setOnAction(new EventHandler<ActionEvent>()
					{
						public void handle(ActionEvent ae)
						{
							source.setCenterX(50);
							source.setCenterY(450);
						}
					});			

					mi1.setOnAction(new EventHandler<ActionEvent>()
					{
						public void handle(ActionEvent ae)
						{
							Stage next = new Stage();
							VBox root3 = new VBox(10);
							Label l11 = new Label("RIGHT ARROW KEY - Move source to right");
							Label l12 = new Label("LEFT ARROW KEY - Move source to left");
							Label l13 = new Label("DOWN ARROW KEY - Move source down");
							Label l14 = new Label("UP ARROW KEY - Move source up");
				
							l11.setFont(new Font("Consolas", 18));
							l12.setFont(new Font("Consolas", 18));
							l13.setFont(new Font("Consolas", 18));
							l14.setFont(new Font("Consolas", 18));
							
							Button OK = new Button("Got it!");

							OK.setOnAction(new EventHandler<ActionEvent>()
							{
								public void handle(ActionEvent ae)
								{
									next.close();
								}
							});

							root3.getChildren().addAll(l11,l12,l13,l14,OK);
							root3.setAlignment(Pos.CENTER);
							Scene s2 = new Scene(root3,500,500,Color.rgb(100,100,150,0.5));
					
							next.setTitle("Controls");
							next.setScene(s2);
							next.setX(stage1.getX()+100);
							next.setY(stage1.getY()+200);
							next.initModality(Modality.WINDOW_MODAL); 
							next.initOwner(stage1);
							next.show();
						}
					});

					
					mi2.setOnAction(new EventHandler<ActionEvent>()
					{
						public void handle(ActionEvent ae)
						{
							Stage next = new Stage();
							VBox root3 = new VBox(10);
							Label l11 = new Label("1. Use arrow keys to move");
							Label l12 = new Label("2. Reach destination on screen");
							Label l13 = new Label("3. Avoid touching the obstacles");
				
							l11.setFont(new Font("Consolas", 26));
							l12.setFont(new Font("Consolas", 26));
							l13.setFont(new Font("Consolas", 26));
						
							Button OK = new Button("Got it!");

							OK.setOnAction(new EventHandler<ActionEvent>()
							{
								public void handle(ActionEvent ae)
								{
									next.close();
								}
							});

							root3.getChildren().addAll(l11,l12,l13,OK);
							root3.setAlignment(Pos.CENTER);
							Scene s2 = new Scene(root3,500,500,Color.rgb(100,100,150,0.5));
					
							next.setTitle("How to play");
							next.setScene(s2);
							next.setX(stage1.getX()+100);
							next.setY(stage1.getY()+200);
							next.initModality(Modality.WINDOW_MODAL); 
							next.initOwner(stage1);
							next.show();
						}
					});
					
					mi4.setOnAction(new EventHandler<ActionEvent>()
					{
						public void handle(ActionEvent ae)
						{
							next.close();
						}
					});

					// GAME
					
					Pane game = new Pane();
					Circle dest = new Circle(450,50,50);
					
					
					dest.setFill(Color.GREEN);
					source.setFill(Color.PURPLE);


					//Adding obstacles
				
					Circle o1 = new Circle(150,50,50);
					Circle o2 = new Circle(350,150,50);
					Circle o3 = new Circle(250,250,50);
					Circle o4 = new Circle(150,350,50);
					Circle o5 = new Circle(350,350,50);
					Circle o6 = new Circle(450,450,50);
					o1.setFill(Color.rgb(213,17,27));
					o2.setFill(Color.rgb(213,17,27));
					o3.setFill(Color.rgb(213,17,27));
					o4.setFill(Color.rgb(213,17,27));
					o5.setFill(Color.rgb(213,17,27));
					o6.setFill(Color.rgb(213,17,27));



					TextField tt = new TextField();
					tt.setMaxWidth(0.1);
					//GAME INTERFACE USING EVENTHANDLING
					

					tt.setOnKeyPressed(new EventHandler<KeyEvent>()
					{
						public void handle(KeyEvent ke)
						{
							KeyCode code = ke.getCode();
							switch(code)
							{
								case UP		:source.setCenterY(source.getCenterY()-100);
							 		  	 break;
								case DOWN	:source.setCenterY(source.getCenterY()+100);
										 break;
								case RIGHT	:source.setCenterX(source.getCenterX()+100);
							 			 break;
								case LEFT	:source.setCenterX(source.getCenterX()-100);
										 break;
								default		: System.out.println(code);
							}
							if((source.getCenterX()==150 && source.getCenterY()==50) || (source.getCenterX()==350 && source.getCenterY()==150) || (source.getCenterX()==250 && source.getCenterY()==250) ||	(source.getCenterX()==150 && source.getCenterY()==350) || (source.getCenterX()==350 && source.getCenterY()==350) || (source.getCenterX()==450 && source.getCenterY()==450))
							{
								G_Name.setText("Game over");
								next.close();
							}
							if(source.getCenterX()==450 && source.getCenterY()==50)
							{
								G_Name.setText("YOU WON!!");
								next.close();
							}
								
						}
					});
					
					

					game.getChildren().addAll(dest,source,o1,o2,o3,o4,o5,o6,tt);
					//ADDING EVERYTHING



					root4.getChildren().addAll(mb,game);
					Scene s2 = new Scene(root4,500,532);
					

					next.setTitle("Let's Play!!");
					next.setScene(s2);
					next.setX(stage1.getX()+100);
					next.setY(stage1.getY()+200);
					next.initModality(Modality.WINDOW_MODAL); 
					next.initOwner(stage1);
					next.show();
				}
			});

		





		//ADDING TO MAIN ROOT
		
		root.getChildren().addAll(G_Name,root1,root2);
		root.setAlignment(Pos.CENTER);


		



		//Adding nodes to root

		Scene s = new Scene(root,1000,1000);
		s.setFill(Color.rgb(100,100,150,0.5));
		stage1.setScene(s);
		stage1.setTitle("Game");
		stage1.show();
	}
	public static void main(String ...args)
	{
		launch(args);
	}
}