package it.Twitter.FollowersAnalyzer.Model;

	public class User extends Super{
		
		private String name;
		private String username;
		private int followersCount;
		private int friendsCount;
		

		public User(Long id) {
			super(id);
		}
		
		
		public User(Long id, String name) {
			super(id);
			this.name = name;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public int getFollowersCount() {
			return followersCount;
		}


		public void setFollowersCount(int followersCount) {
			this.followersCount = followersCount;
		}


		public int getFriendsCount() {
			return friendsCount;
		}


		public void setFriendsCount(int friendsCount) {
			this.friendsCount = friendsCount;
		}


		public User(Long id, String name, String username) {
			super(id);
			this.username = name;
			this.name = username;
		}


		@Override
		public String toString() {
			return "User [id="+ getId() + ",name=" + name + ", username=" + username + "]";
		}
		
		

}