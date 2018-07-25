using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Runtime.InteropServices;
using UnityEngine;

public class InitialStart : MonoBehaviour {

	[DllImport ("user32.dll")]
	private static extern uint GetActiveWindow ();

	public static IntPtr hWnd;

	public void Start () {
		hWnd = (IntPtr) GetActiveWindow ();

		Screen.SetResolution (440, 360, false);
		string filename1 = "GithubLinks.txt";
		string filename2 = "LatestLog.txt";
		string filename3 = "README.md";

		if (!File.Exists (filename1)) {
			using (File.Create (filename1))
			Debug.Log ("Made " + filename1);
		} else {
			Debug.Log (filename1 + " already exists");
		}

		if (!File.Exists (filename2)) {
			using (File.Create (filename2))
			Debug.Log ("Made " + filename2);
		} else {
			Debug.Log (filename2 + " already exists");
		}

		if (!File.Exists (filename3)) {
			using (File.Create (filename3))
			Debug.Log ("Made " + filename3);
		} else {
			Debug.Log (filename3 + " already exists");
		}
	}
}/
