import { TestBed } from '@angular/core/testing';

import { RequirementServiceService } from './requirement-service.service';

describe('RequirementServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RequirementServiceService = TestBed.get(RequirementServiceService);
    expect(service).toBeTruthy();
  });
});
