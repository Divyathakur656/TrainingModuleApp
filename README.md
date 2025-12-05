Training Modules App is a small native Android app in Kotlin that shows a list of training modules and lets the user mark them as completed with local database..

Home screen: vertical list of modules (title, short description, status: Completed / Pending)

Detail screen: shows full title + full description; allows toggling status (Mark Completed / Mark Pending)

Persistent status: module completion statuses are saved using SharedPreferences — so they survive app restarts

MVVM architecture: separation of concerns (data / repository / view‑models / UI)

Used Jetpack Navigation for navigation.

