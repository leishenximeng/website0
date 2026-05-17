<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import axios from 'axios'

const route = useRoute()

const article = ref<any>({})

onMounted(async () => {
  const id = route.params.id
  const res = await axios.get(`http://124.222.121.94:8080/api/articles/${id}`)
  article.value = res.data
})
</script>

<template>
  <div>
    <h1>{{ article.title }}</h1>
    <p>{{ article.content }}</p>
  </div>
</template>