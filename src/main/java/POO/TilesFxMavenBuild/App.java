package POO.TilesFxMavenBuild;



import java.util.Locale;

import eu.hansolo.tilesfx.tools.Helper;
import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.addons.Indicator;
import eu.hansolo.tilesfx.colors.Bright;
import eu.hansolo.tilesfx.colors.Dark;
import eu.hansolo.tilesfx.tools.FlowGridPane;
import eu.hansolo.tilesfx.Tile.SkinType;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import machines.PompeAirComprime;

/**
 * JavaFX App
 */
public class App extends Application {
    private static final    double TILE_WIDTH  = 350;
    private static final    double TILE_HEIGHT = 175;
    private PompeAirComprime machine = new PompeAirComprime("Pompe Air Comprimé","P0125",15,12,12,5,50,100,40);
    private int cycles = 0;
    
    @Override
    public void start(Stage stage) {
            
        Tile clockTile = TileBuilder.create()
                .skinType(SkinType.CLOCK)
                .prefSize(TILE_WIDTH, TILE_HEIGHT)
                .title("Date")
                .dateVisible(true)
                .locale(Locale.US)
                .running(true)
                .build();

        Tile temperatureTile = TileBuilder.create()
                .skinType(SkinType.BAR_GAUGE)
                .prefSize(TILE_WIDTH, TILE_HEIGHT)
                .minValue(0)
                .maxValue(machine.getTemperatureMax()*2)
                .startFromZero(true)
                .threshold(machine.getTemperatureMax())
                .thresholdVisible(true)
                .title("Temperature")
                .unit("°C")
                .gradientStops(new Stop(0, Bright.BLUE),
                               new Stop(0.1, Bright.BLUE_GREEN),
                               new Stop(0.2, Bright.GREEN),
                               new Stop(0.3, Bright.GREEN_YELLOW),
                               new Stop(0.4, Bright.YELLOW),
                               new Stop(0.5, Bright.YELLOW_ORANGE),
                               new Stop(0.6, Bright.ORANGE),
                               new Stop(0.7, Bright.ORANGE_RED),
                               new Stop(0.8, Bright.RED),
                               new Stop(1.0, Dark.RED))
                .strokeWithGradient(true)
                .animated(true)
                .build();
        
        Tile temperatureSparkLineTile = TileBuilder.create()
                .skinType(SkinType.SPARK_LINE)
                .prefSize(TILE_WIDTH, TILE_HEIGHT)
                .title("Courbe Temperature")
                .unit("°C")
                .gradientStops(new Stop(0, Tile.GREEN),
                               new Stop(0.5, Tile.YELLOW),
                               new Stop(1.0, Tile.RED))
                .strokeWithGradient(true)
                //.smoothing(true)
                .build();
       
       Tile pressureTile = TileBuilder.create()
               .skinType(SkinType.BAR_GAUGE)
               .prefSize(TILE_WIDTH, TILE_HEIGHT)
               .minValue(0)
               .maxValue(machine.getPressionMax()*2)
               .startFromZero(true)
               .threshold(machine.getPressionMax())
               .thresholdVisible(true)
               .title("Pressure")
               .unit("Pa")
               .gradientStops(new Stop(0, Bright.BLUE),
                              new Stop(0.1, Bright.BLUE_GREEN),
                              new Stop(0.2, Bright.GREEN),
                              new Stop(0.3, Bright.GREEN_YELLOW),
                              new Stop(0.4, Bright.YELLOW),
                              new Stop(0.5, Bright.YELLOW_ORANGE),
                              new Stop(0.6, Bright.ORANGE),
                              new Stop(0.7, Bright.ORANGE_RED),
                              new Stop(0.8, Bright.RED),
                              new Stop(1.0, Dark.RED))
               .strokeWithGradient(true)
               .animated(true)
               .build();
       Tile pressureSparkLineTile = TileBuilder.create()
               .skinType(SkinType.SPARK_LINE)
               .prefSize(TILE_WIDTH, TILE_HEIGHT)
               .title("Courbe Pression")
               .unit("Pa")
               .gradientStops(new Stop(0, Tile.GREEN),
                              new Stop(0.5, Tile.YELLOW),
                              new Stop(1.0, Tile.RED))
               .strokeWithGradient(true)
               //.smoothing(true)
               .build();
       
       Tile noiseLevelTile = TileBuilder.create()
               .skinType(SkinType.BAR_GAUGE)
               .prefSize(TILE_WIDTH, TILE_HEIGHT)
               .minValue(0)
               .maxValue(machine.getNoiseMax()*2)
               .startFromZero(true)
               .threshold(machine.getNoiseMax())
               .thresholdVisible(true)
               .title("Niveau De Bruit")
               .unit("dB")
               .gradientStops(new Stop(0, Bright.BLUE),
                              new Stop(0.1, Bright.BLUE_GREEN),
                              new Stop(0.2, Bright.GREEN),
                              new Stop(0.3, Bright.GREEN_YELLOW),
                              new Stop(0.4, Bright.YELLOW),
                              new Stop(0.5, Bright.YELLOW_ORANGE),
                              new Stop(0.6, Bright.ORANGE),
                              new Stop(0.7, Bright.ORANGE_RED),
                              new Stop(0.8, Bright.RED),
                              new Stop(1.0, Dark.RED))
               .strokeWithGradient(true)
               .animated(true)
               .build();
       
       Tile noiseLevelSparkLineTile = TileBuilder.create()
               .skinType(SkinType.SPARK_LINE)
               .prefSize(TILE_WIDTH, TILE_HEIGHT)
               .title("Courbe Bruit")
               .unit("dB")
               .gradientStops(new Stop(0, Tile.GREEN),
                              new Stop(0.5, Tile.YELLOW),
                              new Stop(1.0, Tile.RED))
               .strokeWithGradient(true)
               //.smoothing(true)
               .build();
       
       Tile productionTile = TileBuilder.create()
               .skinType(SkinType.LED)
               .prefSize(TILE_WIDTH, TILE_HEIGHT)
               .title("Etat de production")
               .build();

       Tile objectiveTile = TileBuilder.create().skinType(SkinType.CHARACTER)
               .prefSize(TILE_WIDTH, TILE_HEIGHT)
               .title("Objectif du jour")
               .titleAlignment(TextAlignment.CENTER)
               .description(Integer.toString(machine.getNumberOfProductsByCycle()))
               .build();
       Tile switchTile = TileBuilder.create()
               .skinType(SkinType.SWITCH)
               .prefSize(TILE_WIDTH, TILE_HEIGHT)
               .title("Eclairage")
               .build();
       Button emergencyStopButton = new Button("Arret Urgence");
       emergencyStopButton.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold;");
       emergencyStopButton.setAlignment(Pos.CENTER);
       emergencyStopButton.setPrefSize(100, 100);
       emergencyStopButton.setShape(new javafx.scene.shape.Circle(50));
       emergencyStopButton.setOnMouseEntered(e -> emergencyStopButton.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;"));
       emergencyStopButton.setOnMouseExited(e -> emergencyStopButton.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold;"));

       Tile countdownTile = TileBuilder.create()
               .skinType(SkinType.COUNTDOWN_TIMER)
               .prefSize(TILE_WIDTH, TILE_HEIGHT)
               .title("Prochain Cycle Dans")
               .barColor(Bright.ORANGE_RED)
               .timePeriod(java.time.Duration.ofSeconds(machine.getDurationOfCycle()))
               .build();
       if (!countdownTile.isRunning()) {
           countdownTile.setTimePeriod(java.time.Duration.ofSeconds(machine.getDurationOfCycle()));
           countdownTile.setRunning(true);
       }
       Tile stopTile = TileBuilder.create()
               .skinType(SkinType.CUSTOM)
               .prefSize(TILE_WIDTH, TILE_HEIGHT)
               .title("Arret Urgence")
               .graphic(emergencyStopButton)
               .roundedCorners(true)
               .build();
       
       Tile circularProgressTile = TileBuilder.create()
               .skinType(SkinType.CIRCULAR_PROGRESS)
               .prefSize(TILE_WIDTH, TILE_HEIGHT)
               .title("Progression de la production")
               .unit(Helper.PERCENTAGE)
               .build();

       Tile fluidTile = TileBuilder.create().skinType(SkinType.FLUID)
                              .prefSize(TILE_WIDTH, TILE_HEIGHT)
                              .title("Fluid Tile")
                              .text("Waterlevel")
                              .unit("\u0025")
                              .decimals(0)
                              .barColor(Tile.BLUE) // defines the fluid color, alternatively use sections or gradientstops
                              .animated(true)
                              .build();
       productionTile.setActive(true);
       Tile gazTile = TileBuilder.create()
               .skinType(SkinType.GAUGE_SPARK_LINE)
               .prefSize(TILE_WIDTH, TILE_HEIGHT)
               .title("Emissions de Gaz")
               .animated(true)
               .value((double)machine.getSensorData("GazEmission"))
               .valueVisible(true)
               .textVisible(false)
               .averagingPeriod(25)
               .autoReferenceValue(true)
               .barColor(Tile.YELLOW_ORANGE)
               .barBackgroundColor(Color.rgb(255, 255, 255, 0.1))
               .sections(new eu.hansolo.tilesfx.Section(0, 33, Tile.LIGHT_GREEN),
                         new eu.hansolo.tilesfx.Section(33, 67, Tile.YELLOW),
                         new eu.hansolo.tilesfx.Section(67, 100, Tile.LIGHT_RED))
               .sectionsVisible(true)
               .highlightSections(true)
               .strokeWithGradient(true)
               .gradientStops(new Stop(0.0, Tile.LIGHT_GREEN),
                              new Stop(0.33, Tile.LIGHT_GREEN),
                              new Stop(0.33,Tile.YELLOW),
                              new Stop(0.67, Tile.YELLOW),
                              new Stop(0.67, Tile.LIGHT_RED),
                              new Stop(1.0, Tile.LIGHT_RED))
               .build();
       Indicator leftGraphics = new Indicator(Tile.RED);
       leftGraphics.setOn(true);

       Indicator middleGraphics = new Indicator(Tile.YELLOW);
       middleGraphics.setOn(true);

       Indicator rightGraphics = new Indicator(Tile.GREEN);
       rightGraphics.setOn(true);
       Tile statusTile = TileBuilder.create()
               .skinType(SkinType.STATUS)
               .prefSize(TILE_WIDTH, TILE_HEIGHT)
               .title("Status Tile")
               .description("Notifications")
               .leftText("CRITICAL")
               .middleText("WARNING")
               .rightText("INFORMATION")
               .leftGraphics(leftGraphics)
               .middleGraphics(middleGraphics)
               .rightGraphics(rightGraphics)
               .text("Text")
               .build();
                // Create a FlowGridPane to hold the tiles
                FlowGridPane pane = new FlowGridPane(4,3,
                		clockTile,countdownTile,switchTile,stopTile,
                		temperatureTile, pressureTile,noiseLevelTile,objectiveTile,
                		temperatureSparkLineTile,pressureSparkLineTile,noiseLevelSparkLineTile,productionTile,
                		fluidTile,gazTile,statusTile,circularProgressTile);
                
                pane.setHgap(5);
                pane.setVgap(5);
                pane.setAlignment(Pos.CENTER);
                pane.setCenterShape(true);
                pane.setPadding(new Insets(5));
                //pane.setPrefSize(800, 600);
                pane.setBackground(new Background(new BackgroundFill(Color.web("#101214"), CornerRadii.EMPTY, Insets.EMPTY)));


                // Create a Timeline to update the values
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
                    if (!countdownTile.isRunning()) {
                    	setCycles(getCycles() + 1);
                        countdownTile.setTimePeriod(java.time.Duration.ofSeconds(machine.getDurationOfCycle()));
                        countdownTile.setRunning(true);
                    }
                    Random random = new Random();
                    boolean ledState = machine.isOn();
                    double temperature = machine.getSensorData("Temperature");
                    double pressure = machine.getSensorData("Pressure");
                    double noise = machine.getSensorData("Noise");
                    temperatureTile.setValue(temperature);
                    pressureTile.setValue(pressure);
                    temperatureSparkLineTile.setValue(temperature);
                    pressureSparkLineTile.setValue(pressure);
                    noiseLevelTile.setValue(noise);
                    noiseLevelSparkLineTile.setValue(noise);
                    gazTile.setValue(machine.getSensorData("GazEmission"));
                    fluidTile.setValue(machine.getSensorData("WaterLevel"));
                    if(ledState) {
                    	productionTile.setActiveColor(Color.LIGHTGREEN);
                    }else {
                    	productionTile.setActiveColor(Color.RED);
                    }

                    circularProgressTile.setValue(cycles);

                    
                }));
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
                emergencyStopButton.setOnAction(event -> {
             	   machine.setOn(false);
             	   productionTile.setActiveColor(Color.RED);
             	   countdownTile.setRunning(false);
             	   timeline.stop();
             	   
                });
                // Create a Scene and set it to the Stage
                Scene scene = new Scene(pane);
                stage.setTitle("TilesFX Demo");
                stage.setScene(scene);
                stage.show();
            }

	



    public static void main(String[] args) {
       launch(args);
    }





	public int getCycles() {
		return cycles;
	}





	public void setCycles(int cycles) {
		this.cycles = cycles;
	}

}