using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class OpenLinks : MonoBehaviour {

	public Button button;
	public void Start () {
		Button task = button.GetComponent<Button> ();
		task.onClick.AddListener (OpenFile);
	}

	public void OpenFile () {
		System.Diagnostics.Process.Start (button.name);
	}
}