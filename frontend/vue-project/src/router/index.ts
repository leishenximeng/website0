import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '../views/HomeView.vue'
import ArticlesView from '../views/ArticlesView.vue'
import ArticleDetailView from '../views/ArticleDetailView.vue'
import CreateArticleView from '../views/CreateArticleView.vue'
import EditArticleView from '../views/EditArticleView.vue'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: HomeView
    },
    {
      path: '/articles',
      component: ArticlesView
    },
    {
      path: '/article/:id',
      component: ArticleDetailView
    },

    {
      path: '/create',
      component: CreateArticleView
    },
    {
      path: '/edit/:id',
      component: EditArticleView
    }
  ]
})

export default router