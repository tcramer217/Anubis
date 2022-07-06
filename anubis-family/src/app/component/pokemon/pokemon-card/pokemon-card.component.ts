import {Component, Input, OnInit} from '@angular/core';
import {Card} from "../../../model/card";

@Component({
  selector: 'app-pokemon-card',
  templateUrl: './pokemon-card.component.html',
  styleUrls: ['./pokemon-card.component.less']
})
export class PokemonCardComponent implements OnInit {

  @Input()
  card: Card = {
    name:'test',
    showDetails: false,
    images: {
      small: ''
    }
  };

  constructor() { }

  ngOnInit(): void {
  }

  showDetails() {
    this.card.showDetails = true;
  }

  hideDetails() {
    this.card.showDetails = false;
  }

}
