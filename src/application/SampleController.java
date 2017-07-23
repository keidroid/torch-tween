package application;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import red.torch.tween.Ease;
import red.torch.tween.Tween;

public class SampleController {

	@FXML
	private Label tweenSample;

	@FXML
	private ImageView easeLinear;
	@FXML
	private ImageView easeSineIn;
	@FXML
	private ImageView easeSineOut;
	@FXML
	private ImageView easeSineInOut;
	@FXML
	private ImageView easeQuadIn;
	@FXML
	private ImageView easeQuadOut;
	@FXML
	private ImageView easeQuadInOut;
	@FXML
	private ImageView easeCubicIn;
	@FXML
	private ImageView easeCubicOut;
	@FXML
	private ImageView easeCubicInOut;
	@FXML
	private ImageView easeExpoIn;
	@FXML
	private ImageView easeExpoOut;
	@FXML
	private ImageView easeExpoInOut;
	@FXML
	private ImageView easeBackIn;
	@FXML
	private ImageView easeBackOut;
	@FXML
	private ImageView easeBackInOut;
	@FXML
	private ImageView easeElasticIn;
	@FXML
	private ImageView easeElasticOut;
	@FXML
	private ImageView easeElasticInOut;
	@FXML
	private ImageView easeBounceIn;
	@FXML
	private ImageView easeBounceOut;
	@FXML
	private ImageView easeBounceInOut;

	@FXML
	private ImageView easeSmooth;
	@FXML
	private ImageView easeQuadSmooth;
	@FXML
	private ImageView easeSmoother;

	@FXML
	private void initialize() {
	}

	@FXML
	public void onClickTweenButton(ActionEvent event) {
		//
		// Tween Sample
		//
		Node target = tweenSample;
		target.setTranslateX(0);
		target.setTranslateY(0);
		target.setScaleX(1);
		target.setScaleY(1);
		target.setRotate(0);

		Transition t = Tween.sequence(target,
				Tween.moveTo(0.1, target, 0, 0),
				Tween.fadeOut(0.2, target),
				Tween.delay(0.4),
				Tween.parallel(target,
						Tween.fadeIn(0.6, target, Ease.QUAD_SMOOTHSTEP),
						Tween.scaleTo(0.4, target, 0.5)),
				Tween.moveToY(1.2, target, 200, Ease.SMOOTHERSTEP),
				Tween.parallel(target,
						Tween.moveBy(0.4, target, 20.0, -50.0, Ease.BACK_OUT),
						Tween.scaleTo(0.4, target, 1.0, Ease.ELASTIC_OUT)),
				Tween.moveTo(0.4, target, 0, 0, Ease.ELASTIC_OUT),
				Tween.event(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent t) {
						System.out.print("call event when animation");
					}
				}),
				Tween.delay(2.0),
				Tween.moveTo(0.4, target, 100, 100, Ease.BOUNCE_OUT),
				Tween.delay(1.0),
				Tween.moveTo(0.4, target, 0, 0, Ease.EXPO_OUT),
				Tween.rotateBy(0.4, target, 720.0, Ease.SMOOTHSTEP),
				Tween.rotateTo(0.1, target, 0.0, Ease.QUAD_OUT));
		t.play();
	}

	@FXML
	public void onClickEaseButton(ActionEvent event) {
		//
		//Ease Sample
		//
		double duration = 1.0;

		easeLinear.setTranslateX(0);
		Tween.moveToX(duration, easeLinear, 200, Ease.LINEAR).play();

		// In

		easeSineIn.setTranslateX(0);
		Tween.moveToX(duration, easeSineIn, 200, Ease.SINE_IN).play();
		easeQuadIn.setTranslateX(0);
		Tween.moveToX(duration, easeQuadIn, 200, Ease.QUAD_IN).play();
		easeCubicIn.setTranslateX(0);
		Tween.moveToX(duration, easeCubicIn, 200, Ease.CUBIC_IN).play();
		easeExpoIn.setTranslateX(0);
		Tween.moveToX(duration, easeExpoIn, 200, Ease.EXPO_IN).play();
		easeBackIn.setTranslateX(0);
		Tween.moveToX(duration, easeBackIn, 200, Ease.BACK_IN).play();
		easeElasticIn.setTranslateX(0);
		Tween.moveToX(duration, easeElasticIn, 200, Ease.ELASTIC_IN).play();
		easeBounceIn.setTranslateX(0);
		Tween.moveToX(duration, easeBounceIn, 200, Ease.BOUNCE_IN).play();

		// Out

		easeSineOut.setTranslateX(0);
		Tween.moveToX(duration, easeSineOut, 200, Ease.SINE_OUT).play();
		easeQuadOut.setTranslateX(0);
		Tween.moveToX(duration, easeQuadOut, 200, Ease.QUAD_OUT).play();
		easeCubicOut.setTranslateX(0);
		Tween.moveToX(duration, easeCubicOut, 200, Ease.CUBIC_OUT).play();
		easeExpoOut.setTranslateX(0);
		Tween.moveToX(duration, easeExpoOut, 200, Ease.EXPO_OUT).play();
		easeBackOut.setTranslateX(0);
		Tween.moveToX(duration, easeBackOut, 200, Ease.BACK_OUT).play();
		easeElasticOut.setTranslateX(0);
		Tween.moveToX(duration, easeElasticOut, 200, Ease.ELASTIC_OUT).play();
		easeBounceOut.setTranslateX(0);
		Tween.moveToX(duration, easeBounceOut, 200, Ease.BOUNCE_OUT).play();

		// InOut

		easeSineInOut.setTranslateX(0);
		Tween.moveToX(duration, easeSineInOut, 200, Ease.SINE_BOTH).play();
		easeQuadInOut.setTranslateX(0);
		Tween.moveToX(duration, easeQuadInOut, 200, Ease.QUAD_BOTH).play();
		easeCubicInOut.setTranslateX(0);
		Tween.moveToX(duration, easeCubicInOut, 200, Ease.CUBIC_BOTH).play();
		easeExpoInOut.setTranslateX(0);
		Tween.moveToX(duration, easeExpoInOut, 200, Ease.EXPO_BOTH).play();
		easeBackInOut.setTranslateX(0);
		Tween.moveToX(duration, easeBackInOut, 200, Ease.BACK_BOTH).play();
		easeElasticInOut.setTranslateX(0);
		Tween.moveToX(duration, easeElasticInOut, 200, Ease.ELASTIC_BOTH).play();
		easeBounceInOut.setTranslateX(0);
		Tween.moveToX(duration, easeBounceInOut, 200, Ease.BOUNCE_BOTH).play();

		// Other

		easeSmooth.setTranslateX(0);
		Tween.moveToX(duration, easeSmooth, 200, Ease.SMOOTHSTEP).play();
		easeQuadSmooth.setTranslateX(0);
		Tween.moveToX(duration, easeQuadSmooth, 200, Ease.QUAD_SMOOTHSTEP).play();
		easeSmoother.setTranslateX(0);
		Tween.moveToX(duration, easeSmoother, 200, Ease.SMOOTHERSTEP).play();
	}
}
