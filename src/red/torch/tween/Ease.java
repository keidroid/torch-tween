package red.torch.tween;

import javafx.animation.Interpolator;

/**
 * torch Tween Library (Ease)
 *
 * License:
 * http://www.robertpenner.com/easing_terms_of_use.html
 */
public abstract class Ease extends Interpolator {

	static public final Interpolator SINE_BOTH = SPLINE(0.445, 0.05, 0.55, 0.95);
	static public final Interpolator SINE_IN = SPLINE(0.47, 0, 0.745, 0.715);
	static public final Interpolator SINE_OUT = SPLINE(0.39, 0.575, 0.565, 1);

	static public final Interpolator QUAD_BOTH = SPLINE(0.455, 0.03, 0.515, 0.955);
	static public final Interpolator QUAD_IN = SPLINE(0.55, 0.085, 0.68, 0.53);
	static public final Interpolator QUAD_OUT = SPLINE(0.25, 0.46, 0.45, 0.94);

	static public final Interpolator CUBIC_BOTH = SPLINE(0.645, 0.045, 0.355, 1);
	static public final Interpolator CUBIC_IN = SPLINE(0.55, 0.055, 0.675, 0.19);
	static public final Interpolator CUBIC_OUT = SPLINE(0.215, 0.61, 0.355, 1);

	static public final Interpolator QUART_BOTH = SPLINE(0.77, 0, 0.175, 1);
	static public final Interpolator QUART_IN = SPLINE(0.895, 0.03, 0.685, 0.22);
	static public final Interpolator QUART_OUT = SPLINE(0.165, 0.84, 0.44, 1);

	static public final Interpolator QUINT_BOTH = SPLINE(0.86, 0, 0.07, 1);
	static public final Interpolator QUINT_IN = SPLINE(0.755, 0.05, 0.855, 0.06);
	static public final Interpolator QUINT_OUT = SPLINE(0.23, 1, 0.32, 1);

	static public final Interpolator EXPO_BOTH = SPLINE(1, 0, 0, 1);
	static public final Interpolator EXPO_IN = SPLINE(0.95, 0.05, 0.795, 0.035);
	static public final Interpolator EXPO_OUT = SPLINE(0.19, 1, 0.22, 1);

	static public final Interpolator CIRC_BOTH = SPLINE(0.785, 0.135, 0.15, 0.86);
	static public final Interpolator CIRC_IN = SPLINE(0.6, 0.04, 0.98, 0.335);
	static public final Interpolator CIRC_OUT = SPLINE(0.075, 0.82, 0.165, 1);

	static public final Back BACK_BOTH = new Back(1.70158 * 1.525);
	static public final BackIn BACK_IN = new BackIn(1.70158);
	static public final BackOut BACK_OUT = new BackOut(1.70158);

	static public final Elastic ELASTIC_BOTH = new Elastic();
	static public final ElasticIn ELASTIC_IN = new ElasticIn();
	static public final ElasticOut ELASTIC_OUT = new ElasticOut();

	static public final Bounce BOUNCE_BOTH = new Bounce();
	static public final BounceIn BOUNCE_IN = new BounceIn();
	static public final BounceOut BOUNCE_OUT = new BounceOut();

	/**
	 * Hermite interpolation (Smoothstep)
	 *
	 */
	static public final Ease SMOOTHSTEP = new Ease() {
		@Override
		public double curve(double t) {
			return t * t * (3 - 2 * t);
		}
	};

	/**
	 * Hermite interpolation (Quad Smoothstep)
	 *
	 */
	static public final Ease QUAD_SMOOTHSTEP = new Ease() {
		@Override
		public double curve(double t) {
			t = t * t * (3 - 2 * t);
			return t * t * (3 - 2 * t);
		}
	};

	/**
	 * Ken Perlin suggested an improved version of the smoothstep
	 *
	 */
	static public final Ease SMOOTHERSTEP = new Ease() {
		@Override
		public double curve(double t) {
			return t * t * t * (t * (t * 6 - 15) + 10);
		}
	};

	static public class Back extends Ease {
		final double amount;

		public Back(double amount) {
			this.amount = amount;
		}

		@Override
		public double curve(double t) {
			if ((t *= 2) < 1) {
				return 0.5 * (t * t * ((amount + 1) * t - amount));
			}
			return 0.5 * ((t -= 2) * t * ((amount + 1) * t + amount) + 2);
		}
	};

	static public class BackIn extends Back {
		public BackIn (double amount) {
			super(amount);
		}

		@Override
		public double curve(double t) {
			return t * t * ((amount + 1) * t - amount);
		}
	}

	static public class BackOut extends Back {
		public BackOut (double amount) {
			super(amount);
		}

		@Override
		public double curve(double t) {
			return ((--t) * t * ((amount + 1) * t + amount) + 1);
		}
	}

	static public class Elastic extends Ease {
		@Override
		public double curve(double t) {
			if (t == 0 || t == 1) {
				return t;
			}
			t *= 2;
			if (t < 1) {
				return -0.5 * Math.pow(2, 10 * (t - 1)) * Math.sin((t - 1.1) * 5 * Math.PI);
			}
			return 0.5 * Math.pow(2, -10 * (t - 1)) * Math.sin((t - 1.1) * 5 * Math.PI) + 1;
		}
	}

	static public class ElasticIn extends Ease {
		@Override
		public double curve(double t) {
			if (t == 0 || t == 1) {
				return t;
			}
			return -Math.pow(2, 10 * (t - 1)) * Math.sin((t - 1.1) * 5 * Math.PI);
		}
	}

	static public class ElasticOut extends Ease {
		@Override
		public double curve(double t) {
			return Math.pow(2, -10 * t) * Math.sin((t - 0.1) * 5 * Math.PI) + 1;
		}
	}

	static public class Bounce extends BounceOut {

		@Override
		public double curve(double t) {
			if (t <= 0.5) {
				return (1 - super.curve(1 - t * 2)) * 0.5;
			}
			return super.curve(t * 2 - 1) * 0.5 + 0.5;
		}
	}

	static public class BounceOut extends Ease {
		@Override
		public double curve(double t) {
			if (t < (1 / 2.75)) {
				return 7.5625 * t * t;
			} else if (t < (2 / 2.75)) {
				return 7.5625 * (t -= (1.5 / 2.75)) * t + 0.75;
			} else if (t < (2.5 / 2.75)) {
				return 7.5625 * (t -= (2.25 / 2.75)) * t + 0.9375;
			} else {
				return 7.5625 * (t -= (2.625 / 2.75)) * t + 0.984375;
			}
		}
	}

	static public class BounceIn extends BounceOut {

		@Override
		public double curve(double t) {
			return 1 - super.curve(1 - t);
		}
	}
}
