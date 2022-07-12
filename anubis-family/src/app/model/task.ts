import {User} from './user';
import {Profile} from './profile';

export interface Task {
  id: number;
  name: string;
  assignedTo: Profile;
  createdBy: Profile;
  createdAt: Date;
  complete: boolean;
  inProgress: boolean;
  reminders: any[];
}
