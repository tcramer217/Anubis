import {User} from './user';
import {Profile} from './profile';

export interface Task {
  assignedTo: Profile;
  complete: boolean;
  createdAt: Date;
  createdBy: Profile;
  inProgress: boolean;
  id: number;
  name: string;
  reminders: any[];
}
