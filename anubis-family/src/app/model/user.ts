export interface User {
  id: number;
  username: string;
  accessToken: string;
  email: string;
  roles: string[];
  tokenType: string;
}
