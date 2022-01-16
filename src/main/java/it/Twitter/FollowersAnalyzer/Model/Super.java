package it.Twitter.FollowersAnalyzer.Model;

/** Superclasse Super contentente un generico id, componente condiviso dalle classi {@link it.Twitter.FollowersAnalyzer.Model.Tweet Tweet} e {@link it.Twitter.FollowersAnalyzer.Model.User User}.
 * 
 * @author Sbattella Mattia
 * @author Sumcutean Sara
 * 
 * @see it.Twitter.FollowersAnalyzer.Model.User User
 * @see it.Twitter.FollowersAnalyzer.Model.Tweet Tweet
 */
	public class Super {
		
		private Long id;
		
		/**
		 * Costruttore della classe Super.
		 * 
		 * @param id : Id generico.
		 */
		public Super(Long id) {
			this.id = id;
		}
		
		/**
	     * Metodo che restituisce l'id.
	     * 
	     * @return <Code>id</Code> : id generico.
	     */
		public Long getId() {
			return id;
		}

		/**
	     * Metodo che setta l'id.
	     * 
	     * @param id : id generico.
	     */
		public void setId(Long id) {
			this.id = id;
		}
		
	}

