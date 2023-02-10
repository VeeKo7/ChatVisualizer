import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  optionSelected: string = "";

  constructor() { }

  ngOnInit(): void {
  }

  onSelect(option: string) {
    this.optionSelected = option;
  }

  inputChange(text: string) {
    alert(text)
  }
}
