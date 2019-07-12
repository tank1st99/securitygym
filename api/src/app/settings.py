import os
import random
import string

SECRET_KEY = os.getenv("SECURITY_GYM_SECRET_KEY", None)
if not SECRET_KEY:
    SECRET_KEY = ''.join(random.choice(string.ascii_letters + string.digits) for _ in range(128))

COURSES_PATH = os.getenv("SECURITY_GYM_COURSES_PATH", None)
if not COURSES_PATH:
    COURSES_PATH = os.path.abspath("../../courses")

CHECK_EXECUTOR_URL = os.getenv("CHECK_EXECUTOR_URL", None)
if not CHECK_EXECUTOR_URL:
    CHECK_EXECUTOR_URL = 'http://check-executor:5000/run_check'
