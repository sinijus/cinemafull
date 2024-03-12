import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  server: {
    host: true,
    port:8081,
    proxy: {
      '/api': {
        //for development use
        target: 'http://localhost:8080',
        //for Docker use
        // target: 'http://proovjsback:8080',
        changeOrigin: true,
        secure: false,
        ws: true,
        rewrite: (path) => path.replace(/^\/api/, '')
      }
    }
  },
  preview: {
    host: true,
    port: 8081
  },
  plugins: [vue()],
  resolve: {
    // alias: {
    //   '@': fileURLToPath(new URL('./src', import.meta.url))
    // }
  }
})
