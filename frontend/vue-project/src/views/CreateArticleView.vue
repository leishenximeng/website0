<script setup lang="ts">
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'

const router = useRouter()

const title = ref('')
const content = ref('')

async function submit() {

  await axios.post(
    'http://124.222.121.94:8080/api/articles',
    {
      title: title.value,
      content: content.value
    }
  )

  router.push('/articles')
}
</script>

<template>
  <div>
    <h1>新增文章</h1>

    <div>
      <input v-model="title" placeholder="标题" />
    </div>

    <div>
      <textarea v-model="content" placeholder="内容"></textarea>
    </div>

    <button @click="submit">
      发布
    </button>
  </div>
</template>