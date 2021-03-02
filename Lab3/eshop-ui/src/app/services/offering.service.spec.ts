import {TestBed} from '@angular/core/testing';

import {OfferingService} from './offering.service';

describe('OfferingService', () => {
  let service: OfferingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OfferingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
