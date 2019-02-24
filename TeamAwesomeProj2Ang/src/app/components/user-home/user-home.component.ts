import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {

  constructor() { }

  //userName = "Not Maria";
  userName = JSON.parse(localStorage.getItem("currentUser")).username;

  ngOnInit() {
  }
}

window.onload = function () {
  console.log("Loaded");
  loadCanvas();
  var btnRed = document.getElementById("btn_red");
  var btnGreen = document.getElementById("btn_green");
  var btnBlue = document.getElementById("btn_blue");

  btnRed.addEventListener("click", makeRed);
  btnGreen.addEventListener("click", makeGreen);
  btnBlue.addEventListener("click", makeBlue);
}

function loadCanvas() {
//  var imgElement = document.getElementById("img-cat");
 // var canvas = document.getElementById("canvas-cat");
 //var tempCanvas = <HTMLCanvasElement>{};
 var canvas = <HTMLCanvasElement> document.getElementById("canvas-cat");
 var imgElement = <HTMLImageElement>document.getElementById("img-cat");
  canvas.width = imgElement.width;
  canvas.height = imgElement.height;
  var context = canvas.getContext("2d");
  context.clearRect(0, 0, canvas.width, canvas.height);
  context.drawImage(imgElement, 0, 0);
  var imgData = context.getImageData(0, 0, imgElement.width, imgElement.height);
  var pxData = imgData.data;
  context.putImageData(imgData, 0, 0);
  console.log("Pause");
}

function makeRed() {
  //var imgElement = document.getElementById("img-cat");
 // var canvas = document.getElementById("canvas-cat");
 var canvas = <HTMLCanvasElement> document.getElementById("canvas-cat");
 var imgElement = <HTMLImageElement>document.getElementById("img-cat");
  var context = canvas.getContext("2d");
  context.clearRect(0, 0, canvas.width, canvas.height);
  context.drawImage(imgElement, 0, 0);
  var imgData = context.getImageData(0, 0, imgElement.width, imgElement.height);
  var pxData = imgData.data;
  for (var i = 0, n = pxData.length; i < n; i += 4) {
    pxData[i] = 255;
  }
  context.putImageData(imgData, 0, 0)
}

function makeGreen() {
  var canvas = <HTMLCanvasElement> document.getElementById("canvas-cat");
  var imgElement = <HTMLImageElement>document.getElementById("img-cat");
  //var canvas = document.getElementById("canvas-cat");
  var context = canvas.getContext("2d");
  context.clearRect(0, 0, canvas.width, canvas.height);
  context.drawImage(imgElement, 0, 0);
  var imgData = context.getImageData(0, 0, imgElement.width, imgElement.height);
  var pxData = imgData.data;
  for (var i = 0, n = pxData.length; i < n; i += 4) {
    pxData[i + 1] = 255;
  }
  context.putImageData(imgData, 0, 0)
}

function makeBlue() {
 // var imgElement = document.getElementById("img-cat");
 // var canvas = document.getElementById("canvas-cat");
 var canvas = <HTMLCanvasElement> document.getElementById("canvas-cat");
 var imgElement = <HTMLImageElement>document.getElementById("img-cat");
  var context = canvas.getContext("2d");
  context.clearRect(0, 0, canvas.width, canvas.height);
  context.drawImage(imgElement, 0, 0);
  var imgData = context.getImageData(0, 0, imgElement.width, imgElement.height);
  var pxData = imgData.data;
  for (var i = 0, n = pxData.length; i < n; i += 4) {
    pxData[i + 2] = 255;
  }
  context.putImageData(imgData, 0, 0)
}


