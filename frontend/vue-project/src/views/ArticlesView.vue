<script setup lang="ts">
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'

const router = useRouter()

const articles = ref<any[]>([])

async function loadArticles() {

  const res = await axios.get(
    'http://124.222.121.94:8080/api/articles'
  )

  articles.value = res.data
}

onMounted(() => {
  loadArticles()
})

function goDetail(id: number) {
  router.push(`/article/${id}`)
}

async function remove(id: number) {

  await axios.delete(
    `http://124.222.121.94:8080/api/articles/${id}`
  )

  loadArticles()
}

function edit(id: number) {
  router.push(`/edit/${id}`)
}

</script>

<template>
  <div>
    <h1>文章列表</h1>

    <ul>
      <li v-for="item in articles" :key="item.id">

        <a href="#" @click.prevent="goDetail(item.id)">
          {{ item.title }}
        </a>

        <button @click="edit(item.id)">
          编辑
        </button>

        <button @click="remove(item.id)">
          删除
        </button>

      </li>
    </ul>
  </div>
</template>