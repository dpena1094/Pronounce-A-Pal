using Android.App;
using Android.Content;
using Android.Widget;
using Android.OS;

namespace Pronounce_A_Pal {
	[Activity(Label = "Pronounce_A_Pal", MainLauncher = true, Icon = "@mipmap/icon")]
	public class MainActivity : Activity {
		private int _count = 1;

		protected override void OnCreate(Bundle savedInstanceState) {
			base.OnCreate(savedInstanceState);

			// Set our view from the "main" layout resource
			SetContentView(Resource.Layout.Main);

			// Get our button from the layout resource,
			// and attach an event to it
			var button = FindViewById<Button>(Resource.Id.myButton);
			var splashButton = FindViewById<Button>(Resource.Id.SplashButton);
			var landingButton = FindViewById<Button>(Resource.Id.LandingButton);
			var evaluationButton = FindViewById<Button>(Resource.Id.EvaluationButton);
			var trainingButton = FindViewById<Button>(Resource.Id.TrainingButton);

			button.Click += delegate { button.Text = $"{_count++} clicks!"; };
			splashButton.Click += delegate {
				var activity = new Intent(this, typeof(SplashActivity));
				StartActivity(activity);
				Finish();
			};
			landingButton.Click += delegate {
				var activity = new Intent(this, typeof(LandingActivity));
				StartActivity(activity);
				Finish();
			};
			evaluationButton.Click += delegate {
				var activity = new Intent(this, typeof(EvaluationActivity));
				StartActivity(activity);
				Finish();
			};
			trainingButton.Click += delegate {
				var activity = new Intent(this, typeof(TrainingActivity));
				StartActivity(activity);
				Finish();
			};
		}
	}
}

