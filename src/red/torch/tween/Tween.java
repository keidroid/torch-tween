package red.torch.tween;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 * torch Tween Library (Tween)
 *
 */
public class Tween {

	//sequence

	public static SequentialTransition sequence(Node node, Animation... children) {
		return new SequentialTransition(node, children);
	}

	//parallel

	public static ParallelTransition parallel(Node node, Animation... children) {
		return new ParallelTransition(node, children);
	}

	//delay

	public static PauseTransition delay(double duration) {
		return new PauseTransition(Duration.seconds(duration));
	}

	// event

	public static Animation event(EventHandler<ActionEvent> value) {
		Animation t = delay(0.0);
		t.setOnFinished(value);
		return t;
	}

	//fade

	public static FadeTransition fadeTo(double duration, Node target, double to) {
		return fadeTo(duration, target, to, Ease.SMOOTHSTEP);
	}

	public static FadeTransition fadeTo(double duration, Node target, double to, Interpolator ease) {
		FadeTransition t = new FadeTransition();
		t.setNode(target);
		t.setDuration(Duration.seconds(duration));
		t.setToValue(to);
		t.setInterpolator(ease);
		return t;
	}

	public static FadeTransition fadeIn(double duration, Node target) {
		return fadeIn(duration, target, Ease.SMOOTHERSTEP);
	}

	public static FadeTransition fadeIn(double duration, Node target, Interpolator ease) {
		return fadeTo(duration, target, 1.0, ease);
	}

	public static FadeTransition fadeOut(double duration, Node target) {
		return fadeOut(duration, target, Ease.SMOOTHERSTEP);
	}

	public static FadeTransition fadeOut(double duration, Node target, Interpolator ease) {
		return fadeTo(duration, target, 0.0, ease);
	}

	//color

	public static FillTransition fillColorTo(double duration, Shape target, Color to) {
		return fillColorTo(duration, target, to, Ease.SMOOTHERSTEP);
	}

	public static FillTransition fillColorTo(double duration, Shape target, Color to, Interpolator ease) {
		FillTransition t = new FillTransition(Duration.seconds(duration), target);
		t.setToValue(to);
		t.setInterpolator(ease);
		return t;
	}

	public static StrokeTransition strokeColorTo(Shape target, double duration, Color to) {
	     return strokeColorTo(target, duration, to, Ease.LINEAR);
	}

	public static StrokeTransition strokeColorTo(Shape target, double duration, Color to, Interpolator ease) {
		StrokeTransition t = new StrokeTransition(Duration.seconds(duration), target);
		t.setToValue(to);
		t.setInterpolator(ease);
		return t;
	}

	//path

	public static PathTransition pathTo(Node target, double duration, Shape path) {
	     return pathTo(target, duration, path, Ease.LINEAR);
	}

	public static PathTransition pathTo(Node target, double duration, Shape path, Interpolator ease) {
		PathTransition t = new PathTransition(Duration.seconds(duration), path, target);
		t.setInterpolator(ease);
		return t;
	}

	// rotate

	public static RotateTransition rotateTo(double duration, Node target, double to) {
		return rotateTo(duration, target, to, Ease.LINEAR);
	}

	public static RotateTransition rotateTo(double duration, Node target, double to, Interpolator ease) {
		RotateTransition t = new RotateTransition(Duration.seconds(duration), target);
		t.setToAngle(to);
		t.setInterpolator(ease);
		return t;
	}

	public static RotateTransition rotateBy(double duration, Node target, double by) {
		return rotateBy(duration, target, by, Ease.LINEAR);
	}

	public static RotateTransition rotateBy(double duration, Node target, double by, Interpolator ease) {
		RotateTransition t = new RotateTransition(Duration.seconds(duration), target);
		t.setByAngle(by);
		t.setInterpolator(ease);
		return t;
	}

	//scale

	public static ScaleTransition scaleTo(double duration, Node target, double to) {
		return scaleTo(duration, target, to, to, Ease.LINEAR);
	}

	public static ScaleTransition scaleTo(double duration, Node target, double to, Interpolator ease) {
		return scaleTo(duration, target, to, to, ease);
	}

	public static ScaleTransition scaleTo(double duration, Node target, double toX, double toY) {
		return scaleTo(duration, target, toX, toY, Ease.LINEAR);
	}

	public static ScaleTransition scaleTo(double duration, Node target, double toX, double toY, Interpolator ease) {
		ScaleTransition t = new ScaleTransition(Duration.seconds(duration), target);
		t.setToX(toX);
		t.setToY(toY);
		t.setInterpolator(ease);
		return t;
	}

	public static ScaleTransition scaleBy(double duration, Node target, double by) {
		return scaleBy(duration, target, by, by, Ease.LINEAR);
	}

	public static ScaleTransition scaleBy(double duration, Node target, double by, Interpolator ease) {
		return scaleBy(duration, target, by, by, ease);
	}

	public static ScaleTransition scaleBy(double duration, Node target, double byX, double byY) {
		return scaleBy(duration, target, byX, byY, Ease.LINEAR);
	}

	public static ScaleTransition scaleBy(double duration, Node target, double byX, double byY, Interpolator ease) {
		ScaleTransition t = new ScaleTransition(Duration.seconds(duration), target);
		t.setByX(byX);
		t.setByY(byY);
		t.setInterpolator(ease);
		return t;
	}

	//move

	public static TranslateTransition moveToX(double duration, Node target, double to) {
		return moveToX(duration, target, to, Ease.LINEAR);
	}

	public static TranslateTransition moveToX(double duration, Node target, double to, Interpolator ease) {
		TranslateTransition t = new TranslateTransition(Duration.seconds(duration), target);
		t.setToX(to);
		t.setInterpolator(ease);
		return t;
	}

	public static TranslateTransition moveToY(double duration, Node target, double to) {
		return moveToY(duration, target, to, Ease.LINEAR);
	}

	public static TranslateTransition moveToY(double duration, Node target, double to, Interpolator ease) {
		TranslateTransition t = new TranslateTransition(Duration.seconds(duration), target);
		t.setToY(to);
		t.setInterpolator(ease);
		return t;
	}

	public static TranslateTransition moveTo(double duration, Node target, double toX, double toY) {
		return moveTo(duration, target, toX, toY, Ease.LINEAR);
	}

	public static TranslateTransition moveTo(double duration, Node target, double toX, double toY, Interpolator ease) {
		TranslateTransition t = moveToX(duration, target, toX, ease);
		t.setToY(toY);
		return t;
	}

	public static TranslateTransition moveByX(double duration, Node target, double by) {
		return moveByX(duration, target, by, Ease.LINEAR);
	}

	public static TranslateTransition moveByX(double duration, Node target, double by, Interpolator ease) {
		TranslateTransition t = new TranslateTransition(Duration.seconds(duration), target);
		t.setByX(by);
		t.setInterpolator(ease);
		return t;
	}

	public static TranslateTransition moveByY(double duration, Node target, double by) {
		return moveByY(duration, target, by, Ease.LINEAR);
	}

	public static TranslateTransition moveByY(double duration, Node target, double by, Interpolator ease) {
		TranslateTransition t = new TranslateTransition(Duration.seconds(duration), target);
		t.setByY(by);
		t.setInterpolator(ease);
		return t;
	}

	public static TranslateTransition moveBy(double duration, Node target, double byX, double byY) {
		return moveBy(duration, target, byX, byY, Ease.LINEAR);
	}

	public static TranslateTransition moveBy(double duration, Node target, double byX, double byY, Interpolator ease) {
		TranslateTransition t = moveByX(duration, target, byX, ease);
		t.setByY(byY);
		return t;
	}
}
