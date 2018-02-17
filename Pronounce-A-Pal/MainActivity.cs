using Android.App;
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

			button.Click += delegate { button.Text = $"{_count++} clicks!"; };
		}
	}
}

