<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'

const route = useRoute()
const router = useRouter()

const id = route.params.id

const title = ref('')
const content = ref('')

onMounted(async () => {
  const res = await axios.get(
    `http://124.222.121.94:8080/api/articles/${id}`
  )

  title.value = res.data.title
  content.value = res.data.content
})

async function update() {
  await axios.put(
    `http://124.222.121.94:8080/api/articles/${id}`,
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
    <h1>编辑文章</h1>

    <input v-model="title" placeholder="标题" />

    <br />

    <textarea v-model="content" placeholder="内容"></textarea>

    <br />

    <button @click="update">保存</button>
  </div>
</template>