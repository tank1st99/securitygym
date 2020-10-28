import epicbox


def check(profile, command, files):
    epicbox.configure(
        profiles=[
            epicbox.Profile('python', 'security-gym-python'),
            epicbox.Profile('javascript', 'security-gym-javascript'),
            epicbox.Profile('golang', 'security-gym-golang'),
            epicbox.Profile('java', 'security-gym-java')
        ]
    )
    limits = {'cputime': 2000, 'memory': 4096}
    result = epicbox.run(profile,
                         command,
                         files=files, limits=limits)
    return result
