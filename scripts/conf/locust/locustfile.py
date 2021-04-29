from locust import HttpUser, TaskSet, task, between

# class Tasks(TaskSet):
#   @task(1)
#   def index(self):
#       self.client.get("/api/product/standard/getAll")

# class Tasks(TaskSet):
#   @task(1)
#   def index(self):
#       self.client.get("/api/product/async/getAll")

class Tasks(TaskSet):
  @task(1)
  def index(self):
      self.client.get("/api/product/reactive/getAll")

class WebsiteUser(HttpUser):
  host = "http://127.0.0.1:8080"
  tasks = [Tasks]
  wait_time = between(2, 5)