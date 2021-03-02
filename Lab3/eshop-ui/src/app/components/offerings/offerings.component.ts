import { Component, OnInit } from '@angular/core';
import {Offering} from '../../models/Offering';
import {OfferingService} from '../../services/offering.service';

@Component({
  selector: 'app-offerings',
  templateUrl: './offerings.component.html',
  styleUrls: ['./offerings.component.css']
})
export class OfferingsComponent implements OnInit {

  offerings: Offering[];

  constructor(private offeringService: OfferingService) {
  }

  ngOnInit(): void {
    this.loadOfferings();
  }

  private loadOfferings(): void {
    this.offeringService.getAll()
      .subscribe(offerings => this.offerings = offerings);
  }
}
