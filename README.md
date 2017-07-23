# torch-tween
JavaFx Tween & Ease Library

* [download](https://github.com/keidroid/torch-tween/blob/master/output/torch-tween-0.9.0.jar?raw=true)

# License

* torch-tween is licensed under the Apache 2.0 License.

```
torch-tween
Copyright (c) 2017 torch Inc.
```

* Easing Equations is licensed under the BSD Licence.
[Robert Penner's open source easing equations](http://robertpenner.com/easing_terms_of_use.html).

# Ease
include 33 ease.

* Ease.SINE_BOTH (easeSineInOut)
* Ease.SINE_IN (easeSineIn)
* Ease.SINE_OUT  (easeSineOut)
* Ease.QUAD_BOTH
* Ease.QUAD_IN
* Ease.QUAD_OUT
* Ease.CUBIC_BOTH
* Ease.CUBIC_IN
* Ease.CUBIC_OUT
* Ease.QUART_BOTH
* Ease.QUART_IN
* Ease.QUART_OUT
* Ease.QUINT_BOTH
* Ease.QUINT_IN
* Ease.QUINT_OUT
* Ease.EXPO_BOTH
* Ease.EXPO_IN
* Ease.EXPO_OUT
* Ease.CIRC_BOTH
* Ease.CIRC_IN
* Ease.CIRC_OUT
* Ease.BACK_BOTH
* Ease.BACK_IN
* Ease.BACK_OUT
* Ease.ELASTIC_BOTH
* Ease.ELASTIC_IN
* Ease.ELASTIC_OUT
* Ease.BOUNCE_BOTH
* Ease.BOUNCE_IN
* Ease.BOUNCE_OUT
* Ease.SMOOTHSTEP
* Ease.QUAD_SMOOTHSTEP
* Ease.SMOOTHERSTEP (Ken Perlin suggested an improved version of the smoothstep)

## Sample Code

```
TranslateTransition tt = new TranslateTransition(Duration.millis(2000), target);
tt.setByX(200);
tt.setInterpolator(Ease.QUAD_OUT);
tt.play();
```

# Tween
Transition Shortcut.

* Tween.sequence
* Tween.parallel
* Tween.delay
* Tween.event
* Tween.fadeTo
* Tween.fadeIn
* Tween.fadeOut
* Tween.moveTo
* Tween.moveToX
* Tween.moveToY
* Tween.moveBy
* Tween.moveByX
* Tween.moveByY
* Tween.fillColorTo
* Tween.strokeColorTo
* Tween.pathTo
* Tween.rotateTo
* Tween.rotateBy
* Tween.scaleTo
* Tween.scaleBy

## Sample Code

```
Transition t = Tween.sequence(target,
    Tween.fadeOut(0.2, target),
    Tween.delay(0.4),
    Tween.parallel(target,
        Tween.fadeIn(0.6, target, Ease.QUAD_SMOOTHSTEP),
        Tween.scaleTo(0.4, target, 0.5)
    ),
    Tween.moveToY(1.2, target, 200, Ease.SMOOTHERSTEP),
    Tween.event(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
            System.out.print("call event");
        }
    }),
    Tween.moveTo(0.1, target, 0, 0));
t.play();
```