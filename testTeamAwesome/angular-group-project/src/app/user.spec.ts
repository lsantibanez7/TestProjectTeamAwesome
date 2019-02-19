import { User } from './user';
import { stringify } from '@angular/core/src/render3/util';

describe('User', () => {
  it('should create an instance', () => {
    expect(new User("email","password")).toBeTruthy();
  });
});
