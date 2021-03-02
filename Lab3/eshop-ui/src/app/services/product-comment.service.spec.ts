import {TestBed} from '@angular/core/testing';

import {ProductCommentService} from './product-comment.service';

describe('ProductCommentService', () => {
  let service: ProductCommentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductCommentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
