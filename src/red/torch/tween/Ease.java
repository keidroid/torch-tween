package red.torch.tween;

import javafx.animation.Interpolator;

/**
 * torch Tween Library (Ease)
 *
 * sine, quad, cubic, quart, quint, expo, circ, back, elastic, bounce
 * brings Robert Penner's easing functions
 *
 * See the following to learn more about these famous functions:
 * http://www.robertpenner.com/easing/
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

	static public final Interpolator QUART_BOTH = SPLINE(0.86, 0, 0.07, 1);
	static public final Interpolator QUART_IN = SPLINE(0.895, 0.03, 0.685, 0.22);
	static public final Interpolator QUART_OUT = SPLINE(0.165, 0.84, 0.44, 1);

	static public final Interpolator QUINT_BOTH = SPLINE(0.86, 0, 0.07, 1);
	static public final Interpolator QUINT_IN = SPLINE(0.755, 0.05, 0.855, 0.06);
	static public final Interpolator QUINT_OUT = SPLINE(0.23, 1, 0.32, 1);

	static public final Interpolator EXPO_BOTH = SPLINE(1, 0, 0, 1);
	static public final Interpolator EXPO_IN = SPLINE(0.95, 0.05, 0.795, 0.035);
	static public final Interpolator EXPO_OUT = SPLINE(0.19, 1, 0.22, 1);

	static public final Interpolator CIRC_BOTH = SPLINE(0.19, 1, 0.22, 1);
	static public final Interpolator CIRC_IN = SPLINE(0.6, 0.04, 0.98, 0.335);
	static public final Interpolator CIRC_OUT = SPLINE(0.785, 0.135, 0.15, 0.86);

	static public final Back BACK_BOTH = new Back(1.70158);
	static public final BackIn BACK_IN = new BackIn(1.70158);
	static public final BackOut BACK_OUT = new BackOut(1.70158);

	static public final Elastic ELASTIC_BOTH = new Elastic(1, 0.3 * 1.5);
	static public final ElasticIn ELASTIC_IN = new ElasticIn(1, 0.3);
	static public final ElasticOut ELASTIC_OUT = new ElasticOut(1, 0.3);

	static public final Bounce BOUNCE_BOTH = new Bounce(4);
	static public final BounceIn BOUNCE_IN = new BounceIn(4);
	static public final BounceOut BOUNCE_OUT = new BounceOut(4);

	/**
	 * Hermite interpolation (Smoothstep)
	 *
	 */
	static public final Ease SMOOTHSTEP = new Ease() {
		@Override
		public double curve(double a) {
			return a * a * (3 - 2 * a);
		}
	};

	/**
	 * Hermite interpolation (Quad Smoothstep)
	 *
	 */
	static public final Ease QUAD_SMOOTHSTEP = new Ease() {
		@Override
		public double curve(double a) {
			a = a * a * (3 - 2 * a);
			return a * a * (3 - 2 * a);
		}
	};

	/**
	 * Ken Perlin suggested an improved version of the smoothstep
	 *
	 */
	static public final Ease SMOOTHERSTEP = new Ease() {
		@Override
		public double curve(double a) {
			return a * a * a * (a * (a * 6 - 15) + 10);
		}
	};

	static public class Back extends Ease {
		final double amount;

		public Back(double amount) {
			this.amount = amount;
		}

		@Override
		public double curve(double t) {
			double amount = this.amount * 1.525;
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
		static final double PI2 = (Math.PI * 2);
		final double amplitude, period;

		public Elastic (double amplitude, double period) {
			this.amplitude = amplitude;
			this.period = period;
		}

		@Override
		public double curve(double t) {
			double s = period / (PI2) * Math.asin(1 / amplitude);
			if ((t *= 2) < 1) {
				return -0.5 * (amplitude * Math.pow(2, 10 * (t -= 1)) * Math.sin((t - s) * PI2 / period ));
			}
			return amplitude * Math.pow(2, -10 * (t -= 1)) * Math.sin((t - s) * PI2 / period) * 0.5 + 1;
		}
	}

	static public class ElasticIn extends Elastic {
		public ElasticIn (double amplitude, double period) {
			super(amplitude, period);
		}

		@Override
		public double curve(double t) {
			if (t == 0 || t == 1) {
				return t;
			}
			double s = period / PI2 * Math.asin(1 / amplitude);
			return -(amplitude * Math.pow(2, 10 * (t -= 1)) * Math.sin((t - s) * PI2 / period));
		}
	}

	static public class ElasticOut extends Elastic {
		public ElasticOut (double amplitude, double period) {
			super(amplitude, period);
		}

		@Override
		public double curve(double t) {
			if (t == 0 || t == 1) {
				return t;
			}
			double s = period / PI2 * Math.asin(1 / amplitude);
			return (amplitude * Math.pow(2, -10 * t) * Math.sin((t - s) * PI2 / period) + 1);
		}
	}

	static public class Bounce extends BounceOut {
		public Bounce (double[] widths, double[] heights) {
			super(widths, heights);
		}

		public Bounce(int bounces) {
			super(bounces);
		}

		private double out(double a) {
			double tmp = a + widths[0] * 0.5;
			if (tmp < widths[0]) {
				return tmp / (widths[0] / 2) - 1;
			}
			return super.curve(a);
		}

		@Override
		public double curve(double a) {
			if (a <= 0.5) {
				return (1 - out(1 - a * 2)) * 0.5;
			}
			return out(a * 2 - 1) * 0.5 + 0.5;
		}
	}

	static public class BounceOut extends Ease {
		final double[] widths, heights;

		public BounceOut(double[] widths, double[] heights) {
			if (widths.length != heights.length)
				throw new IllegalArgumentException("Must be the same number of widths and heights.");
			this.widths = widths;
			this.heights = heights;
		}

		public BounceOut(int bounces) {
			if (bounces < 2 || bounces > 5) throw new IllegalArgumentException("bounces cannot be < 2 or > 5: " + bounces);
			widths = new double[bounces];
			heights = new double[bounces];
			heights[0] = 1;
			switch (bounces) {
			case 2:
				widths[0] = 0.6;
				widths[1] = 0.4;
				heights[1] = 0.33;
				break;
			case 3:
				widths[0] = 0.4;
				widths[1] = 0.4;
				widths[2] = 0.2;
				heights[1] = 0.33;
				heights[2] = 0.1;
				break;
			case 4:
				widths[0] = 0.34;
				widths[1] = 0.34;
				widths[2] = 0.2;
				widths[3] = 0.15;
				heights[1] = 0.26;
				heights[2] = 0.11;
				heights[3] = 0.03;
				break;
			case 5:
				widths[0] = 0.3;
				widths[1] = 0.3;
				widths[2] = 0.2;
				widths[3] = 0.1;
				widths[4] = 0.1;
				heights[1] = 0.45;
				heights[2] = 0.3;
				heights[3] = 0.15;
				heights[4] = 0.06;
				break;
			}
			widths[0] *= 2;
		}

		@Override
		public double curve(double a) {
			if (a == 1) return 1;
			a += widths[0] / 2;
			double width = 0, height = 0;
			for (int i = 0, n = widths.length; i < n; i++) {
				width = widths[i];
				if (a <= width) {
					height = heights[i];
					break;
				}
				a -= width;
			}
			a /= width;
			double z = 4 / width * height * a;
			return 1 - (z - z * a) * width;
		}
	}

	static public class BounceIn extends BounceOut {
		public BounceIn (double[] widths, double[] heights) {
			super(widths, heights);
		}

		public BounceIn (int bounces) {
			super(bounces);
		}

		@Override
		public double curve(double a) {
			return 1 - super.curve(1 - a);
		}
	}
}
