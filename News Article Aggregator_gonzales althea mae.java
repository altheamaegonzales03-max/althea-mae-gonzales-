class NewsAggregator {
  constructor(articles = []) {
    this.articles = articles;
  }

  getTotalViews() {
    return this.articles.reduce((sum, a) => sum + a.views, 0);
  }

  filterByCategory(category) {
    return this.articles.filter(a => 
      a.category.toLowerCase() === category.toLowerCase()
    );
  }

  getMostViewed() {
    if (this.articles.length === 0) return null;
    return this.articles.reduce((max, a) =>
      a.views > max.views ? a : max
    );
  }

  groupByAuthor() {
    return this.articles.reduce((groups, a) => {
      if (!groups[a.author]) groups[a.author] = [];
      groups[a.author].push(a);
      return groups;
    }, Object.create(null));
  }

  async fetchNewArticles() {
    return new Promise(resolve => {
      setTimeout(() => {
        const newArticles = [
          { title: "Space Exploration", author: "Diana", category: "Science", views: 410 },
          { title: "Mental Health Tips", author: "Bob", category: "Health", views: 275 }
        ];
        resolve(newArticles);
      }, 2000);
    });
  }

  async updateArticles() {
    const newArticles = await this.fetchNewArticles();
    this.articles = [...this.articles, ...newArticles];
    return this.articles;
  }

  sortByViews(desc = true) {
    return [...this.articles].sort((a, b) =>
      desc ? b.views - a.views : a.views - b.views
    );
  }

  sortByTitle() {
    return [...this.articles].sort((a, b) =>
      a.title.localeCompare(b.title)
    );
  }

  sortByAuthor() {
    return [...this.articles].sort((a, b) =>
      a.author.localeCompare(b.author)
    );
  }
}


const articles = [
  { title: "AI in 2025", author: "Alice", category: "Technology", views: 350 },
  { title: "Healthy Living", author: "Bob", category: "Health", views: 220 },
  { title: "Climate Change", author: "Alice", category: "Environment", views: 480 },
  { title: "New Movie Release", author: "Carol", category: "Entertainment", views: 600 },
  { title: "Nutrition Facts", author: "Bob", category: "Health", views: 300 }
];

const aggregator = new NewsAggregator(articles);

console.log("🔹 Total Views:", aggregator.getTotalViews());
console.log("🔹 Health Articles:", aggregator.filterByCategory("Health"));
console.log("🔹 Most Viewed:", aggregator.getMostViewed());
console.log("🔹 Grouped by Author:", aggregator.groupByAuthor());
console.log("🔹 Sorted by Views:", aggregator.sortByViews());
console.log("🔹 Sorted by Title:", aggregator.sortByTitle());
console.log("🔹 Sorted by Author:", aggregator.sortByAuthor());


(async () => {
  const updated = await aggregator.updateArticles();
  console.log("🔹 Updated Articles:", updated);
  console.log("🔹 New Total Views:", aggregator.getTotalViews());
})();.articles.reduce((groups, a) => {
      if (!groups[a.author]) groups[a.author] = [];
      groups[a.author].push(a);
      return groups;
    }, Object.create(null));
  }

  async fetchNewArticles() {
    return new Promise(resolve => {
      setTimeout(() => {
        const newArticles = [
          { title: "Space Exploration", author: "Diana", category: "Science", views: 410 },
          { title: "Mental Health Tips", author: "Bob", category: "Health", views: 275 }
        ];
        resolve(newArticles);
      }, 2000);
    });
  }

  async updateArticles() {
    const newArticles = await this.fetchNewArticles();
    this.articles = [...this.articles, ...newArticles];
    return this.articles;
  }

  sortByViews(desc = true) {
    return [...this.articles].sort((a, b) =>
      desc ? b.views - a.views : a.views - b.views
    );
  }

  
  sortByTitle() {
    return [...this.articles].sort((a, b) =>
      a.title.localeCompare(b.title)
    );
  }

  sortByAuthor() {
    return [...this.articles].sort((a, b) =>
      a.author.localeCompare(b.author)
    );
  }
}