<!--task-3 (by using margin) -->
<!--Layout-->
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:accessibilityTraversalAfter="@id/null"
    android:rotationX="-2"
    android:padding="10dp"
    tools:context=".MainActivity">

<!--heading-->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/app_title"
        android:textStyle="bold"
        android:textSize="20sp"
        android:layout_marginTop="10dp"
        android:textAlignment="center"
        android:textColor="@color/white"
        android:background="#1E9ACA"
        android:layout_alignParentTop="true"
        />

<!--top-->

    <ImageView
        android:layout_width="180dp"
        android:layout_height="200dp"
        android:layout_marginStart="10dp"
        android:layout_marginTop="55dp"
        android:scaleType="fitXY"
        android:src="@drawable/pokemon" />

    <ImageView
        android:layout_width="180dp"
        android:layout_height="200dp"
        android:layout_marginStart="200dp"
        android:layout_marginTop="55dp"
        android:scaleType="fitXY"
        android:src="@drawable/pokemon" />

<!--center-->
    <ImageView
        android:layout_width="180dp"
        android:layout_height="200dp"
        android:layout_marginStart="10dp"
        android:layout_marginTop="280dp"
        android:scaleType="fitXY"
        android:src="@drawable/pokemon" />

    <ImageView
        android:layout_width="180dp"
        android:layout_height="200dp"
        android:layout_marginStart="200dp"
        android:layout_marginTop="280dp"
        android:scaleType="fitXY"
        android:src="@drawable/pokemon" />

<!--bottom-->
    <ImageView
        android:layout_width="180dp"
        android:layout_height="200dp"
        android:layout_marginStart="10dp"
        android:layout_marginTop="510dp"
        android:scaleType="fitXY"
        android:src="@drawable/pokemon" />

    <ImageView
        android:layout_width="180dp"
        android:layout_height="200dp"
        android:layout_marginStart="200dp"
        android:layout_marginTop="510dp"
        android:scaleType="fitXY"
        android:src="@drawable/pokemon" />

</RelativeLayout>
